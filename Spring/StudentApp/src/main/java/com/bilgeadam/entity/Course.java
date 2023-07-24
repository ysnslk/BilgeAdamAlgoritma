package com.bilgeadam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //mappedBy --> karşılıklı kurulan ilişkilerde işlemlerin  nereden yönetileceğini belirleyen özelliktir
    @OneToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<Instructor> instructor;
    //fetch --> Veritabanındaki verilerin program çalışırken yüklenip yüklenmeyeceğini belirtir.
    //LAZY(default fetchtype) --> tembel yükelem --> Lazy ile işaretlenen ilişkiler çağırılmadığı sürece program ayağa kalktığında yüklenmez.
    //EAGER --> program çalıştığında veritabanında bulunan veriler hibernate tarafından hazır hale getirilir.
    //Bir ilişkideki verilerin her şekilde çağırılacağı bir durumda EAGER kullanılabilir.Sebebide zaten veriler yükleneceği
    // için her seferinde sorgu atıldığında aynı işlemin tekrar etmemesini sağlamaktır.
    // @JoinTable() --> Oluşacak tabloya isim vermek için kullanılırç
    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students;

    /**
     * Object references an unsaved transient instance - save the transient instance before flushing:
     * Bu hatanın sebebi ilişkili sınıfların birbirine müdahale edememeisinnden kaynaklanır.
     * Yanı course sınıfı 'parent' , Student ve Instructor sınıfları ise 'child' sınıftır.
     * Bu hata parent sınıftan child sınıflara müdahale edemezsin demektir. Bunu giderebilmek için CascadeType.ALL kullanılmalıdır.
     */
}
