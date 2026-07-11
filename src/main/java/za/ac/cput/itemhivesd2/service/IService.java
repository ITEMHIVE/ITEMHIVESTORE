package za.ac.cput.itemhivesd2.service;
/*Interface Service-Service Class
Kelly Pauline Nolte(218275358)
Date:25.July.2026*/
public interface IService <T, ID>{

T create(T t);
T read(ID id);
T update(T t);
boolean delete(ID id);

}//end of class

