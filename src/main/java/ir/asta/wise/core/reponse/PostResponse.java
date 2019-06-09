package ir.asta.wise.core.reponse;

import ir.asta.training.contacts.entities.DetailsEntity;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import java.util.List;

/**
 * Created by ASUS on 6/6/2019.
 */
public class PostResponse {

    private String to_username;
    private String title;
    private String status;
    private String lastUpdate;
    private String detail;
    private boolean satisfied;
//    private Attachment attachment;
    private List<DetailsEntity> otherDescriptions;

    public PostResponse() {
    }

    public PostResponse(String to_username, String title, String status, String lastUpdate, String detail, boolean satisfied, List<DetailsEntity> otherDescriptions) {
        this.to_username = to_username;
        this.title = title;
        this.status = status;
        this.lastUpdate = lastUpdate;
        this.detail = detail;
        this.satisfied = satisfied;
//        this.attachment = attachment;
        this.otherDescriptions = otherDescriptions;
    }

    public String getTo_username() {
        return to_username;
    }

    public void setTo_username(String to_username) {
        this.to_username = to_username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isSatisfied() {
        return satisfied;
    }

    public void setSatisfied(boolean satisfied) {
        this.satisfied = satisfied;
    }

//    public Attachment getAttachment() {
//        return attachment;
//    }
//
//    public void setAttachment(Attachment attachment) {
//        this.attachment = attachment;
//    }

    public List<DetailsEntity> getOtherDescriptions() {
        return otherDescriptions;
    }

    public void setOtherDescriptions(List<DetailsEntity> otherDescriptions) {
        this.otherDescriptions = otherDescriptions;
    }
}
