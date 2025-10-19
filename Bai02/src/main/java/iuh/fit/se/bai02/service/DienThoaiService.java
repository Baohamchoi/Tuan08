package iuh.fit.se.bai02.service;

import iuh.fit.se.bai02.model.DienThoai;

import java.util.List;
import java.util.Optional;

public interface DienThoaiService {
    List<DienThoai> getAll();
    List<DienThoai> getByNhaCungCap(String maNcc);
    List<DienThoai> searchByName(String keyword);
    Optional<DienThoai> getById(String maDt);
    DienThoai save(DienThoai dienThoai);
    void deleteById(String maDt);
}
