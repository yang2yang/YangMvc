package cn.qingtianr.model;

/**
 * Created by jack-pc on 2017/4/28.
 */
public class MessageBean {
    private Integer id;
    private Boolean isSuccess;
    private String message;
    private String content;

    public MessageBean(){

    }

    public MessageBean(Boolean isSuccess,String message){
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
