package com.aw.bracelet.utils;


import com.aw.bracelet.constants.Constants;
import org.apache.commons.lang.CharEncoding;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class QDZipUtils {

	/** 是否QD压缩数据 */
	public static boolean isQDDATA(byte[] data) {
		InputStream is = new ByteArrayInputStream(data);
		byte[] headBytes = new byte[6];
		try {
			is.read(headBytes);
			is.close();
			String head = new String(headBytes, CharEncoding.US_ASCII);
			return head.equals("QDDATA");
		} catch (Exception e) {
			return false;
		}
	}

	/** 过虑QDDATA */
	public static byte[] filterQDDATA(byte[] data) throws IOException {
		if (!isQDDATA(data)) {
			return data;
		}
		InputStream is = new ByteArrayInputStream(data);
		DataInputStream dis = new DataInputStream(is);
		// 跳过6字节头
		dis.skipBytes(6);
		// 取元数据长度
		int metalen = dis.readShort();
		// 读取数据元
		byte[] metaBytes = new byte[metalen];
		dis.read(metaBytes);
		// 数据元解析为字符串
		// String meta = new String(metaBytes, CharEncoding.UTF_8);
		// 读取数据长度
		int dataLen = dis.readInt();
		byte[] decompressedData = new byte[dataLen];
		dis.read(decompressedData);
		dis.close();
		is.close();
		// 对数据进行解压缩
		decompressedData = uncompress(decompressedData);
		return decompressedData;
	}

	/** 转换数据为QDDATA */
	public static byte[] makeQDDATA(byte[] data) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		String head = "QDDATA";
		byte[] headByts = head.getBytes(Constants.CHARSET.UTF8);
		dos.write(headByts);
		String meta = "ver=1&cm=gz";
		byte[] metaBytes = meta.getBytes(Constants.CHARSET.UTF8);
		dos.writeShort(metaBytes.length);
		dos.write(metaBytes);
		// 压缩数据
		byte[] compressedData = compress(data);
		dos.writeInt(compressedData.length);
		dos.write(compressedData);
		dos.close();
		os.close();
		return os.toByteArray();
	}

	/** GZIP压缩字节 */
	public static byte[] compress(byte[] data) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		GZIPOutputStream gzip = null;
		try {
			gzip = new GZIPOutputStream(out);
			gzip.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gzip != null) {
				try {
					gzip.close();
				} catch (IOException e) {
				}
			}
		}

		return out.toByteArray();
	}

	/** GZIP解压缩字节 */
	public static byte[] uncompress(byte[] compressedData) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = null;
		GZIPInputStream ginzip = null;
		try {
			in = new ByteArrayInputStream(compressedData);
			ginzip = new GZIPInputStream(in);

			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = ginzip.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ginzip != null) {
				try {
					ginzip.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}

		return out.toByteArray();
	}

	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * HEX编码 将形如0x12 0x2A 0x01 转换为122A01
	 * 
	 * @param data
	 * @return
	 */
	public static String hexEncode(byte[] data) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			String tmp = Integer.toHexString(data[i] & 0xff);
			if (tmp.length() < 2) {
				buffer.append('0');
			}
			buffer.append(tmp);
		}
		String retStr = buffer.toString().toUpperCase();
		return retStr;
	}

	/**
	 * HEX解码 将形如122A01 转换为0x12 0x2A 0x01
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] hexDecode(String data) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		for (int i = 0; i < data.length(); i += 2) {
			String onebyte = data.substring(i, i + 2);
			int b = Integer.parseInt(onebyte, 16) & 0xff;
			out.write(b);
		}
		return out.toByteArray();
	}

}
