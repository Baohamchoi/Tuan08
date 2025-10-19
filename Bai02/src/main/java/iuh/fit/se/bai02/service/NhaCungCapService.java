package iuh.fit.se.bai02.service;

import iuh.fit.se.bai02.model.NhaCungCap;

import java.util.List;
import java.util.Optional;

public interface NhaCungCapService {
    List<NhaCungCap> getAll();
    Optional<NhaCungCap> getById(String maNcc);
    List<NhaCungCap> search(String keyword);
}
