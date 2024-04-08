package exam.repository;

import exam.model.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {

    Optional<Laptop> findFirstByMacAddress(String  address);

   List<Laptop> findByShop_NameAndShop_Town_NameOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc();


//    @Query(value = " SElect s.name, t.name\n" +
//            " from laptops l\n" +
//            " join shops as s on s.id = l.shop_id\n" +
//            " join towns as t on t.id = s.town_id\n" +
//            " GROUP BY l.id \n" +
//            " ORDER BY l.cpu_speed desc, l.ram desc,\n" +
//            " l.storage desc, l.mac_address;",nativeQuery = true)
//    List<Laptop> findAll();
}
