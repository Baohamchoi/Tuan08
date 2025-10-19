package iuh.fit.se.bai02.repository;
import iuh.fit.se.bai02.model.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> {
    List<NhaCungCap> findByTenNccContainingIgnoreCase(String ten);
    List<NhaCungCap> findByDiaChiContainingIgnoreCase(String diaChi);
    List<NhaCungCap> findBySoDienThoaiContaining(String sdt);
}