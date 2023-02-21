package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.HungerApplication;
import untitled.domain.OrderCancled;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String foodid;

    private String option;

    private String addr;

    private String address;

    @PostPersist
    public void onPostPersist() {
        OrderCancled orderCancled = new OrderCancled(this);
        orderCancled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = HungerApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void pay() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }
}
