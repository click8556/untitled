package untitled.domain;

import untitled.domain.*;
import untitled.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class FilePathIndexed extends AbstractEvent {

    private Long id;
    private New Enumeration keywords;
    private Float filed;

    public FilePathIndexed(Index aggregate){
        super(aggregate);
    }
    public FilePathIndexed(){
        super();
    }
}
