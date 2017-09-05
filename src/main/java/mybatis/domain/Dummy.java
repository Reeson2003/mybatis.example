package mybatis.domain;

import java.util.Date;

/**
 * @author Pavel Gavrilov
 *         05.09.2017.
 */
public class Dummy {
    private long id;
    private String text;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
