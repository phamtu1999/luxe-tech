📏 Quy chuẩn đặt tên dự án LUXE-TECH
1. Backend (Spring Boot - Java)
Tuân thủ chuẩn PascalCase cho Class và camelCase cho biến/hàm.

Class/Entity: Phải là danh từ, số ít (Ví dụ: Product, Order, Category).

Interface/Service: Bắt đầu bằng động từ hoặc vai trò (Ví dụ: OrderService, ProductRepository).

Biến/Hàm: Luôn dùng camelCase (Ví dụ: basePrice, calculateTotal()).

Hằng số: Dùng UPPER_SNAKE_CASE (Ví dụ: MAX_STOCK_LIMIT).

2. Database (PostgreSQL - Supabase)
Tuân thủ chuẩn snake_case (Đây là chuẩn của SQL).

Table: Danh từ số nhiều (Ví dụ: products, order_items).

Column: Dùng snake_case (Ví dụ: created_at, sku_code).

Foreign Key: table_name_id (Ví dụ: category_id).

3. Frontend (Vue 3 - Vite)
Sự giao thoa giữa chuẩn JavaScript và Template.

Component: Dùng PascalCase (Ví dụ: ProductCard.vue, AdminSidebar.vue).

Biến/Hàm (Script): Dùng camelCase (Ví dụ: productList, handleCheckout()).

Prop/Event trong Template: Dùng kebab-case (Ví dụ: <product-card :product-data="..." />).

🔄 Quy tắc chuyển đổi dữ liệu (Mapping)
Đây là điểm mấu chốt: Database dùng snake_case nhưng Java dùng camelCase.

Backend: Sử dụng @Column(name = "base_price") để ánh xạ cột database vào biến Java.

API Response: Spring Boot mặc định sẽ trả về JSON theo đúng tên biến của Java (camelCase).

Frontend: Vue 3 sẽ nhận JSON dạng camelCase (Ví dụ: { "basePrice": 30000000 }). Điều này giúp code JavaScript trông tự nhiên hơn.

📂 Quản lý thư mục tài liệu (docs/mota/)
Để team dễ tìm kiếm, bạn nên đánh số thứ tự cho các file .md hiện có:

01_database.md: Cấu trúc 23 bảng.

02_thiet-ke-backend.md: Kiến trúc Layered.

03_api.md: Danh sách các Endpoint.

04_DesignPatterns.md: Các mẫu thiết kế áp dụng.

05_GlobalExceptionHandler.md: Quy trình xử lý lỗi.