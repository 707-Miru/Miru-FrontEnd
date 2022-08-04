package com.back.miru.model.dto;

public class ListParameterDto {
    private int start;
    private int currentPerPage;
    private String keyword;
    private String sortKeyword;
    private boolean ifPicture;
    private String id;

    public ListParameterDto() {
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCurrentPerPage() {
        return currentPerPage;
    }

    public void setCurrentPerPage(int currentPerPage) {
        this.currentPerPage = currentPerPage;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSortKeyword() {
        return sortKeyword;
    }

    public void setSortKeyword(String sortKeyword) {
        this.sortKeyword = sortKeyword;
    }

    public boolean isIfPicture() {
        return ifPicture;
    }

    public void setIfPicture(boolean ifPicture) {
        this.ifPicture = ifPicture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ListParameterDto{" +
                "start=" + start +
                ", currentPerPage=" + currentPerPage +
                ", keyword='" + keyword + '\'' +
                ", sortKeyword='" + sortKeyword + '\'' +
                ", ifPicture=" + ifPicture +
                ", id='" + id + '\'' +
                '}';
    }
}
