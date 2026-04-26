🛠 Hướng dẫn phát triển Hệ thống LUXE-TECH
Dự án này tuân thủ các quy chuẩn kỹ thuật nghiêm ngặt sau đây. Vui lòng đọc kỹ tài liệu trong thư mục docs/mota/ trước khi đặt bút code:

1. Kiến trúc & Design Patterns (Xem DesignPatterns.md)
Creational: Sử dụng Builder cho Entity/DTO phức tạp.

Behavioral: Áp dụng Strategy cho logic tính giá khuyến mãi và hạng Smember.

Structural: Dùng Proxy (Spring Security) để kiểm soát quyền Admin.

2. Quy tắc API & Xử lý lỗi (Xem api.md & GlobalExceptionHandler.md)
Mọi API phải trả về định dạng JSON chuẩn.

Không được trả về lỗi 500 kèm StackTrace. Tất cả lỗi phải được bọc qua GlobalExceptionHandler để trả về message thân thiện cho Frontend Vue 3.

3. Tối ưu hiệu suất (Xem hieusuat.md)
Database: Luôn kiểm tra Index khi viết query mới. Tận dụng JSONB cho thông số kỹ thuật.

Concurrency: API đặt hàng bắt buộc dùng Pessimistic Lock (xem code mẫu trong codemau.md) để chống âm kho.

Async: Các tác vụ gửi mail, log SEO phải chạy ngầm bằng @Async.

4. Phân quyền & Bảo mật (Xem thiet-ke-backend.md)
Kết nối trực tiếp với Supabase Auth.

Kiểm tra Role từ bảng profiles. Tài khoản Admin phải có role = 'ADMIN'.