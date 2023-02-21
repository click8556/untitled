package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class CookFinishied extends AbstractEvent {

    private Long id;

    public CookFinishied(Cooking aggregate) {
        super(aggregate);
    }

    public CookFinishied() {
        super();
    }
}
