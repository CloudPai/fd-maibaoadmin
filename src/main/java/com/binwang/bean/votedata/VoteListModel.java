package com.binwang.bean.votedata;

import java.util.List;

/**
 * Created by yy on 18/5/7.
 */
public class VoteListModel {
    private long id;
    private String imgUrls;
    private String content;

    public VoteListModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }
}
