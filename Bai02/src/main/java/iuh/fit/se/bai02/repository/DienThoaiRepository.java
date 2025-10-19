package iuh.fit.se.bai02.repository;
import iuh.fit.se.bai02.model.DienThoai;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DienThoaiRepository extends JpaRepository<DienThoai, String> {
    List<DienThoai> findByNhaCungCap_MaNcc(String maNcc);
    List<DienThoai> findByTenDtContainingIgnoreCase(String ten);
}
