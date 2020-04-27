package com.aw.braceletserver.entity.oviphone;

public class ReqHistoryWarning extends OviBaseRequset {
    private Integer ID;
    private Integer TypeID;
    private Integer PageNo;
    private Integer PageCount;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getTypeID() {
        return TypeID;
    }

    public void setTypeID(Integer typeID) {
        TypeID = typeID;
    }

    public Integer getPageNo() {
        return PageNo;
    }

    public void setPageNo(Integer pageNo) {
        PageNo = pageNo;
    }

    public Integer getPageCount() {
        return PageCount;
    }

    public void setPageCount(Integer pageCount) {
        PageCount = pageCount;
    }
}
