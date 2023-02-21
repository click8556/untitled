package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.StoreOwnerApplication;
import untitled.domain.CookFinishied;
import untitled.domain.CookStarted;
import untitled.domain.Rejected;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    private Long orderid;

    @PostPersist
    public void onPostPersist() {
        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();

        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();

        CookFinishied cookFinishied = new CookFinishied(this);
        cookFinishied.publishAfterCommit();
    }

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreOwnerApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }
}
