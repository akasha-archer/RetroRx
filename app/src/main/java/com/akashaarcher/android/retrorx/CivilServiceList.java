package com.akashaarcher.android.retrorx;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Akasha on 10/19/17.
 */

public class CivilServiceList {

    @SerializedName("adj_fa")
    @Expose
    private String adjFa;

    @SerializedName("exam_no")
    @Expose
    private String examNo;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("list_no")
    @Expose
    private String listNo;

    @SerializedName("list_title_desc")
    @Expose
    private String listTitleDesc;


    public CivilServiceList() {

    }

    public String getAdjFa() {
        return adjFa;
    }

    public void setAdjFa(String adjFa) {
        this.adjFa = adjFa;
    }

    public String getExamNo() {
        return examNo;
    }

    public void setExamNo(String examNo) {
        this.examNo = examNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getListNo() {
        return listNo;
    }

    public void setListNo(String listNo) {
        this.listNo = listNo;
    }

    public String getListTitleDesc() {
        return listTitleDesc;
    }

    public void setListTitleDesc(String listTitleDesc) {
        this.listTitleDesc = listTitleDesc;
    }

}
