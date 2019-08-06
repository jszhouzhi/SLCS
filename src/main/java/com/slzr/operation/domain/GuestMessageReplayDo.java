package com.slzr.operation.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class GuestMessageReplayDo implements Serializable {
    private static final long serialVersionUID = 1L;
    public String msgid;
    public String replyuid;
    public String replycontent;
    public Date replydatetime;
    public String id;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getReplyuid() {
        return replyuid;
    }

    public void setReplyuid(String replyuid) {
        this.replyuid = replyuid;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }

    public Date getReplydatetime() {
        return replydatetime;
    }

    public void setReplydatetime(Date replydatetime) {
        this.replydatetime = replydatetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
