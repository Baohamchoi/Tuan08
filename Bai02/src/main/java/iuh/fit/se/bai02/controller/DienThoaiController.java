package iuh.fit.se.bai02.controller;

import iuh.fit.se.bai02.model.DienThoai;
import iuh.fit.se.bai02.model.NhaCungCap;
import iuh.fit.se.bai02.service.DienThoaiService;
import iuh.fit.se.bai02.service.NhaCungCapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.Optional;

@Controller
public class DienThoaiController {

    private final DienThoaiService dienThoaiService;
    private final NhaCungCapService nccService;

    @Value("${upload.path}")
    private String uploadPath;

    public DienThoaiController(DienThoaiService dienThoaiService, NhaCungCapService nccService) {
        this.dienThoaiService = dienThoaiService;
        this.nccService = nccService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("dts", dienThoaiService.getAll());
        return "DanhSachContent";
    }

    @GetMapping("/manage")
    public String manage(Model model) {
        model.addAttribute("dts", dienThoaiService.getAll());
        return "QuanLyDienThoai";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dienThoai", new DienThoai());
        model.addAttribute("suppliers", nccService.getAll());
        return "DienThoaiForm";
    }

    @PostMapping("/add")
    public String addDienThoai(@Valid @ModelAttribute("dienThoai") DienThoai dt,
                               BindingResult br,
                               @RequestParam("file") MultipartFile file,
                               @RequestParam("mancc") String mancc,
                               Model model) throws IOException {

        if (br.hasErrors()) {
            model.addAttribute("suppliers", nccService.getAll());
            return "DienThoaiForm";
        }

        if (file != null && !file.isEmpty()) {
            String fname = file.getOriginalFilename();
            String ext = fname.substring(fname.lastIndexOf(".") + 1).toLowerCase();

            if (!ext.matches("png|jpg|jpeg")) {
                br.rejectValue("hinhAnh", "error.dienThoai", "Chỉ chấp nhận file png, jpg, jpeg");
                model.addAttribute("suppliers", nccService.getAll());
                return "DienThoaiForm";
            }

            Path uploadDir = Paths.get(uploadPath);
            if (!Files.exists(uploadDir)) Files.createDirectories(uploadDir);

            String savedName = System.currentTimeMillis() + "_" + fname;
            Path filePath = uploadDir.resolve(savedName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            dt.setHinhAnh(savedName);
        }

        if (mancc != null && !mancc.isEmpty()) {
            Optional<NhaCungCap> nccOpt = nccService.getById(mancc);
            nccOpt.ifPresent(dt::setNhaCungCap);
        }

        dienThoaiService.save(dt);
        return "redirect:/manage";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        System.out.println("🔹 Đang xóa điện thoại có mã: " + id);
        dienThoaiService.deleteById(id);
        return "redirect:/manage";
    }

    @PostMapping("/edit")
    public String updateDienThoai(@RequestParam("id") String id,
                                  @Valid @ModelAttribute("dienThoai") DienThoai dt,
                                  BindingResult br,
                                  @RequestParam("file") MultipartFile file,
                                  @RequestParam("mancc") String mancc,
                                  Model model) throws IOException {

        if (br.hasErrors()) {
            model.addAttribute("suppliers", nccService.getAll());
            return "DienThoaiForm";
        }

        if (file != null && !file.isEmpty()) {
            String fname = file.getOriginalFilename();
            String ext = fname.substring(fname.lastIndexOf(".") + 1).toLowerCase();

            if (!ext.matches("png|jpg|jpeg")) {
                br.rejectValue("hinhAnh", "error.dienThoai", "Chỉ chấp nhận file png, jpg, jpeg");
                model.addAttribute("suppliers", nccService.getAll());
                return "DienThoaiForm";
            }

            Path uploadDir = Paths.get(uploadPath);
            if (!Files.exists(uploadDir)) Files.createDirectories(uploadDir);

            String savedName = System.currentTimeMillis() + "_" + fname;
            Path filePath = uploadDir.resolve(savedName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            dt.setHinhAnh(savedName);
        } else {
            // nếu không upload mới thì giữ lại hình cũ
            DienThoai old = dienThoaiService.getById(id).orElse(null);
            if (old != null) dt.setHinhAnh(old.getHinhAnh());
        }

        if (mancc != null && !mancc.isEmpty()) {
            Optional<NhaCungCap> nccOpt = nccService.getById(mancc);
            nccOpt.ifPresent(dt::setNhaCungCap);
        }

        dienThoaiService.save(dt);
        return "redirect:/manage";
    }
}
