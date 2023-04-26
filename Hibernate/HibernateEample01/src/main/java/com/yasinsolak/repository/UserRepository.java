package com.yasinsolak.repository;

import com.yasinsolak.entity.Information;
import com.yasinsolak.entity.User;
import com.yasinsolak.utility.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserRepository {

    /*
        1- findAll Methodu yazalım tüm userleri listeleyelim, List dönsün
        2- findAllInformation
        3- findAllInformationByName
        4- findById --> User dönsün parametre olarak Long id
        5- findByUsename metodu parametre olarak String username alsın
        6- ismi a ile başlayan kullanıcıları gönelim list dönsün
        7- ismi yine a ile başlayan postcountu 6 nın üzerinde olan kullanıcıları döndürerlim list dönsün
        8- toplam post sayısını bulalım tüm kullanıcıların post sayılarının toplamı. int dönsün
        9- En çok post atmış kişiyi döndürelim
        10- kullanıcıların username gender ve post count dönelim
        11- erkek ve kadın kullanıcı sayısını bulalım
     */
    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    public UserRepository() {
        entityManager = HibernateUtils.getSessionFactory().createEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public List<User> findAll() {
        CriteriaQuery<User> userCriteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(root);
        List<User> userList = entityManager.createQuery(userCriteriaQuery).getResultList();

        return userList;
    }

    public List<User> findAllNativeQuery() {
        String sql = "Select * from tbl_user";
        List<User> users = entityManager.createNativeQuery(sql, User.class).getResultList();
        return users;
    }

    public List<Information> findAllUserInformation() {
        CriteriaQuery<Information> informationCriteriaQuery = criteriaBuilder.createQuery(Information.class);
        Root<User> root = informationCriteriaQuery.from(User.class);
        informationCriteriaQuery.select(root.get("information"));
        List<Information> informationList = entityManager.createQuery(informationCriteriaQuery).getResultList();

        return informationList;
    }

    //select name from tbl_user
    public List<String> findAllInformationByName() {
        CriteriaQuery<String> informationCriteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<User> root = informationCriteriaQuery.from(User.class);
        informationCriteriaQuery.select(root.get("information").get("name"));
        List<String> informationList = entityManager.createQuery(informationCriteriaQuery).getResultList();
        return informationList;
    }

    public User findById(Long id) {
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
        User user = entityManager.createQuery(criteriaQuery).getSingleResult();
        return user;
    }

    public User findByUsername(String username) {
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"), username));
        List<User> users = entityManager.createQuery(criteriaQuery).getResultList();
        // [{user]
        if(users.isEmpty()){
            System.out.println("böyle bir kullanıcı buluanamadı");
            return null;
        }
        return users.get(0);
    }

    public List<User> findByUserStartWithValue(String value){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("information").get("name"), value + "%"));
        List<User> users = entityManager.createQuery(criteriaQuery).getResultList();
        return users;
    }
    public List<User> findByNameAndPostCount(String value,int postCount){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder
                .and(criteriaBuilder.greaterThanOrEqualTo(root.get("postcount"),postCount),
                        criteriaBuilder.like(root.get("information").get("name"),value+"%")));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
    public int sumPost(){
        int count =0;
        CriteriaQuery<User> userCriteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(root);
        List<User> userList = entityManager.createQuery(userCriteriaQuery).getResultList();
        count = userList.stream().mapToInt(User::getPostcount).sum();

        return count;
    }
    public int sumPost2(){
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<User> root = criteriaQuery.from(User.class);
        //Expression<Integer> sum = criteriaBuilder.sum(root.get("postcount"));
        criteriaQuery.select(criteriaBuilder.sum(root.get("postcount")));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public User findUserWithMostPost(){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).orderBy(criteriaBuilder.desc(root.get("postcount")));

        return entityManager.createQuery(criteriaQuery).getResultList().get(0);
    }
    public int findUserWithMostPost2(){
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(criteriaBuilder.max(root.get("postcount")));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public List<Object[]> getUsernameGenderPostCount(){
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<User> root = criteriaQuery.from(User.class);

        Path<String> username = root.get("username");
        Path<String> gender = root.get("eGender");
        Path<Integer> postCount = root.get("postcount");
        criteriaQuery.select(criteriaBuilder.array(username,gender,postCount));
        List<Object[]> users = entityManager.createQuery(criteriaQuery).getResultList();

        users.forEach(x-> {
            System.out.println("username: " + x[0]);
            System.out.println("eGender: " + x[1]);
            System.out.println("postcount: " + x[2]);
            System.out.println("-----------");

        });

        return users;
    }

    public List<Object[]> getUsernameGenderPostCount2(){
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.multiselect(root.get("username"),root.get("eGender"),root.get("postcount"));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<Object[]> getUserbyCountGender(){
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.multiselect(root.get("eGender"),criteriaBuilder.count(root)).groupBy(root.get("eGender"));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }






}
