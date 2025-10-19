package iuh.fit.se.bai02.service.impl;

import iuh.fit.se.bai02.model.NhaCungCap;
import iuh.fit.se.bai02.repository.NhaCungCapRepository;
import iuh.fit.se.bai02.service.NhaCungCapService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {

    private final NhaCungCapRepository nccRepository;

    public NhaCungCapServiceImpl(NhaCungCapRepository nccRepository) {
        this.nccRepository = nccRepository;
    }

    @Override
    public List<NhaCungCap> getAll() {
        return nccRepository.findAll();
    }

    @Override
    public Optional<NhaCungCap> getById(String maNcc) {
        return nccRepository.findById(maNcc);
    }

    @Override
    public List<NhaCungCap> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) return getAll();

        List<NhaCungCap> result = new ArrayList<>();
        result.addAll(nccRepository.findByTenNccContainingIgnoreCase(keyword));
        result.addAll(nccRepository.findByDiaChiContainingIgnoreCase(keyword));
        result.addAll(nccRepository.findBySoDienThoaiContaining(keyword));

        return result.stream().distinct().toList();
    }
}
