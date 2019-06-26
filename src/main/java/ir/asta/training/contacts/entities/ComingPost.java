package ir.asta.training.contacts.entities;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98
/**
 * Created by ASUS on 6/22/2019.
 */
public class ComingPost {
<<<<<<< HEAD
    private int post_id;
=======
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98
    private String from_token;
    private int to_id;
    private String title;
    private String detail;
    private String lastUpdate;
    private String status;
    private boolean satisfied;
<<<<<<< HEAD
    private List<DetailsEntity> otherDescriptions;
=======
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98
//    private Attachment attachment;

    public ComingPost() {}

<<<<<<< HEAD
    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

=======
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98
    public String getFrom_token() {
        return from_token;
    }

    public void setFrom_token(String from_token) {
        this.from_token = from_token;
    }

    public int getTo_id() {
        return to_id;
    }

    public void setTo_id(int to_id) {
        this.to_id = to_id;
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
<<<<<<< HEAD

    public List<DetailsEntity> getOtherDescriptions() {
        return otherDescriptions;
    }

    public void setOtherDescriptions(List<DetailsEntity> otherDescriptions) {
        this.otherDescriptions = otherDescriptions;
    }
=======
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98
}
