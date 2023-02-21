package untitled.domain;

import untitled.domain.FilePathIndexed;
import untitled.IndexerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Index_table")
@Data

public class Index  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private New Enumeration keywords;
    
    
    
    
    
    private Float filed;

    @PostPersist
    public void onPostPersist(){


        FilePathIndexed filePathIndexed = new FilePathIndexed(this);
        filePathIndexed.publishAfterCommit();

    }

    public static IndexRepository repository(){
        IndexRepository indexRepository = IndexerApplication.applicationContext.getBean(IndexRepository.class);
        return indexRepository;
    }




    public static void makeIndex(FileUploaded fileUploaded){

        /** Example 1:  new item 
        Index index = new Index();
        repository().save(index);

        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(index->{
            
            index // do something
            repository().save(index);


         });
        */

        
    }


}
