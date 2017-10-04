package mk.ukim.finki.emt.musicstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.sql.Blob;

@Embeddable
@Data
@EqualsAndHashCode(callSuper=false)
public class FileEmbeddable {

    private Blob data;

    private String fileName;

    private String contentType;

    private Integer size;
}
