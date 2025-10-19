package iuh.fit.se.bai02.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "DIENTHOAI")
public class DienThoai {

    @Id
    @Column(name = "MADT", length = 20)
    private String maDt;

    @NotBlank(message = "Tên điện thoại không được để trống")
    @Column(name = "TENDT", nullable = false)
    private String tenDt;

    @Pattern(regexp = "\\d{4}", message = "Năm sản xuất phải gồm 4 chữ số")
    @Column(name = "NAMSANXUAT")
    private String namSanXuat;

    @NotBlank(message = "Cấu hình không được để trống")
    @Size(max = 255, message = "Cấu hình không quá 255 ký tự")
    @Column(name = "CAUHINH", length = 255)
    private String cauHinh;

    // 🔹 Thêm thuộc tính hình ảnh vào đây
    @Column(name = "HINHANH", length = 255)
    private String hinhAnh;

    // 🔹 Quan hệ tới nhà cung cấp
    @ManyToOne
    @JoinColumn(name = "MANCC")
    private NhaCungCap nhaCungCap;

    // ✅ Constructors
    public DienThoai() {}

    public DienThoai(String maDt, String tenDt, String namSanXuat, String cauHinh, String hinhAnh) {
        this.maDt = maDt;
        this.tenDt = tenDt;
        this.namSanXuat = namSanXuat;
        this.cauHinh = cauHinh;
        this.hinhAnh = hinhAnh;
    }

    // ✅ Getter & Setter
    public String getMaDt() {
        return maDt;
    }

    public void setMaDt(String maDt) {
        this.maDt = maDt;
    }

    public String getTenDt() {
        return tenDt;
    }

    public void setTenDt(String tenDt) {
        this.tenDt = tenDt;
    }

    public String getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(String namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
}
