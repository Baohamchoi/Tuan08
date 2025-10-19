package iuh.fit.se.bai02.service.impl;

import iuh.fit.se.bai02.model.DienThoai;
import iuh.fit.se.bai02.repository.DienThoaiRepository;
import iuh.fit.se.bai02.service.DienThoaiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DienThoaiServiceImpl implements DienThoaiService {

    private final DienThoaiRepository dienThoaiRepository;

    public DienThoaiServiceImpl(DienThoaiRepository dienThoaiRepository) {
        this.dienThoaiRepository = dienThoaiRepository;
    }

    @Override
    public List<DienThoai> getAll() {
        return dienThoaiRepository.findAll();
    }

    @Override
    public List<DienThoai> getByNhaCungCap(String maNcc) {
        if (maNcc == null || maNcc.isEmpty()) return getAll();
        return dienThoaiRepository.findByNhaCungCap_MaNcc(maNcc);
    }

    @Override
    public List<DienThoai> searchByName(String keyword) {
        return dienThoaiRepository.findByTenDtContainingIgnoreCase(keyword);
    }

    @Override
    public Optional<DienThoai> getById(String maDt) {
        return dienThoaiRepository.findById(maDt);
    }

    @Override
    public DienThoai save(DienThoai dienThoai) {
        return dienThoaiRepository.save(dienThoai);
    }

    @Override
    public void deleteById(String maDt) {
        dienThoaiRepository.deleteById(maDt);
    }
}
