<script setup lang="ts">
import { ref } from 'vue'

const steps = [
  { id: 1, name: 'Đã xác nhận', date: '24/05, 14:25', completed: true, active: false },
  { id: 2, name: 'Đang đóng gói', date: '25/05, 09:10', completed: true, active: false },
  { id: 3, name: 'Đang vận chuyển', date: '25/05, 16:45', completed: false, active: true },
  { id: 4, name: 'Đã giao', date: 'Dự kiến 27/05', completed: false, active: false }
]

const history = [
  { status: 'Đơn hàng đã rời kho phân loại', location: 'Bắc Ninh Hub, Việt Nam', time: '25/05, 21:30' },
  { status: 'Đã nhập kho phân loại', location: 'Bắc Ninh Hub, Việt Nam', time: '25/05, 18:15' },
  { status: 'Lấy hàng thành công', location: 'Quận 1, TP. Hồ Chí Minh', time: '25/05, 16:45' },
  { status: 'Người bán đang chuẩn bị hàng', location: 'LUXE-TECH Flagship Store', time: '24/05, 15:00' }
]
</script>

<template>
  <div class="max-w-7xl mx-auto px-8 py-12 flex flex-col lg:flex-row gap-12">
    <!-- Sidebar -->
    <aside class="hidden lg:block w-64 flex-shrink-0 space-y-2">
      <div class="px-4 py-6 mb-4">
        <h2 class="text-xl font-black text-blue-950">Tài khoản</h2>
        <p class="text-[10px] font-black text-orange-500 uppercase tracking-widest mt-1">Khách hàng VIP</p>
      </div>
      <nav class="space-y-1">
        <a v-for="link in [
          { name: 'Bảng điều khiển', icon: 'dashboard', active: false },
          { name: 'Đơn hàng của tôi', icon: 'package_2', active: true },
          { name: 'Sản phẩm yêu thích', icon: 'favorite', active: false },
          { name: 'Cài đặt tài khoản', icon: 'settings', active: false }
        ]" :key="link.name" href="#" 
          class="flex items-center gap-4 px-4 py-3 rounded-xl font-bold transition-all"
          :class="link.active ? 'bg-blue-950 text-white shadow-lg shadow-blue-900/20' : 'text-slate-400 hover:bg-slate-100 hover:text-blue-950'">
          <span class="material-symbols-outlined text-xl">{{ link.icon }}</span>
          <span class="text-sm">{{ link.name }}</span>
        </a>
      </nav>
      <button class="w-full flex items-center gap-4 px-4 py-3 mt-8 text-red-500 font-bold hover:bg-red-50 rounded-xl transition-all">
        <span class="material-symbols-outlined text-xl">logout</span>
        <span class="text-sm">Đăng xuất</span>
      </button>
    </aside>

    <!-- Main Content -->
    <main class="flex-grow space-y-8">
      <!-- Header -->
      <div class="bg-white p-8 rounded-[2rem] border border-slate-100 flex flex-col md:flex-row justify-between items-start md:items-center gap-6">
        <div>
          <p class="text-[10px] font-black text-slate-400 uppercase tracking-widest mb-1">Mã đơn hàng</p>
          <h1 class="text-3xl font-black text-blue-950">#LX-88920412</h1>
          <p class="text-sm font-bold text-slate-400 mt-1">Đặt hàng lúc 14:20, 24 Tháng 5, 2024</p>
        </div>
        <div class="flex gap-4">
          <button class="px-6 py-3 border-2 border-slate-100 rounded-xl font-black text-blue-950 hover:border-blue-950 transition-all text-sm uppercase tracking-widest">In hóa đơn</button>
          <button class="px-6 py-3 bg-blue-950 text-white rounded-xl font-black hover:bg-blue-900 transition-all text-sm uppercase tracking-widest shadow-lg shadow-blue-900/20">Hỗ trợ</button>
        </div>
      </div>

      <!-- Stepper -->
      <div class="bg-white p-12 rounded-[2rem] border border-slate-100">
        <div class="relative flex justify-between">
          <div class="absolute top-6 left-0 w-full h-[2px] bg-slate-100 z-0"></div>
          <div class="absolute top-6 left-0 w-2/3 h-[2px] bg-blue-950 z-0"></div>
          
          <div v-for="step in steps" :key="step.id" class="relative z-10 flex flex-col items-center gap-4 bg-white px-4">
            <div class="w-12 h-12 rounded-full flex items-center justify-center transition-all border-4 border-white shadow-sm"
              :class="step.completed || step.active ? 'bg-blue-950 text-white shadow-blue-900/20' : 'bg-slate-100 text-slate-300'">
              <span class="material-symbols-outlined text-xl" :style="step.completed ? 'font-variation-settings: \'FILL\' 1' : ''">
                {{ step.id === 1 ? 'check_circle' : step.id === 2 ? 'inventory_2' : step.id === 3 ? 'local_shipping' : 'package' }}
              </span>
            </div>
            <div class="text-center">
              <p class="text-xs font-black uppercase tracking-widest" :class="step.completed || step.active ? 'text-blue-950' : 'text-slate-300'">{{ step.name }}</p>
              <p class="text-[10px] font-bold text-slate-400 mt-1">{{ step.date }}</p>
            </div>
          </div>
        </div>
      </div>

      <div class="grid grid-cols-1 lg:grid-cols-3 gap-8">
        <!-- History -->
        <div class="lg:col-span-2 bg-white p-8 rounded-[2rem] border border-slate-100">
          <h3 class="text-xl font-black text-blue-950 mb-8">Lịch sử vận chuyển</h3>
          <div class="relative space-y-10 pl-8">
            <div class="absolute left-0 top-2 bottom-2 w-[2px] bg-slate-100"></div>
            <div v-for="(h, i) in history" :key="i" class="relative">
              <div class="absolute -left-[37px] top-1 w-4 h-4 rounded-full border-4 border-white shadow-sm"
                :class="i === 0 ? 'bg-blue-600 scale-125' : 'bg-slate-200'"></div>
              <div class="flex justify-between items-start">
                <div>
                  <p class="text-sm font-black text-blue-950" :class="i === 0 ? 'text-blue-600' : ''">{{ h.status }}</p>
                  <p class="text-xs font-bold text-slate-400 mt-1">{{ h.location }}</p>
                </div>
                <p class="text-[10px] font-black text-slate-300 uppercase tracking-widest">{{ h.time }}</p>
              </div>
            </div>
          </div>
        </div>

        <!-- Courier & Shipping -->
        <div class="space-y-8">
          <div class="bg-white p-8 rounded-[2rem] border border-slate-100">
            <h4 class="text-[10px] font-black text-slate-400 uppercase tracking-widest mb-6">Đơn vị vận chuyển</h4>
            <div class="flex items-center gap-4 mb-6">
              <div class="w-12 h-12 bg-blue-50 flex items-center justify-center rounded-2xl">
                <span class="material-symbols-outlined text-blue-600">local_shipping</span>
              </div>
              <div>
                <p class="text-sm font-black text-blue-950">LUXE Express Premium</p>
                <p class="text-[10px] font-bold text-slate-400 uppercase tracking-widest">Hàng không</p>
              </div>
            </div>
            <div class="space-y-3 py-6 border-t border-slate-50">
              <div class="flex justify-between text-xs font-bold">
                <span class="text-slate-400">Nhân viên:</span>
                <span class="text-blue-950">Nguyễn Văn An</span>
              </div>
              <div class="flex justify-between text-xs font-bold">
                <span class="text-slate-400">Điện thoại:</span>
                <span class="text-blue-950">090 123 4567</span>
              </div>
            </div>
            <button class="w-full py-4 bg-slate-50 text-blue-950 font-black rounded-xl hover:bg-blue-950 hover:text-white transition-all text-[10px] uppercase tracking-widest">Liên hệ</button>
          </div>

          <div class="bg-white p-8 rounded-[2rem] border border-slate-100">
            <h4 class="text-[10px] font-black text-slate-400 uppercase tracking-widest mb-6">Địa chỉ nhận hàng</h4>
            <div class="flex gap-4">
              <span class="material-symbols-outlined text-blue-600">location_on</span>
              <div>
                <p class="text-sm font-black text-blue-950">Trần Hoàng Nam</p>
                <p class="text-xs font-bold text-slate-400 mt-2 leading-relaxed">88 Đường Lê Lợi, Phường Bến Thành, Quận 1, TP. Hồ Chí Minh</p>
                <p class="text-xs font-black text-blue-950 mt-2">(+84) 912 345 678</p>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- Products -->
      <div class="bg-white p-8 rounded-[2rem] border border-slate-100">
        <h3 class="text-xl font-black text-blue-950 mb-8">Chi tiết sản phẩm</h3>
        <div class="flex items-center gap-6 py-6 border-b border-slate-50 group">
          <div class="w-20 h-20 bg-slate-50 rounded-2xl overflow-hidden flex-shrink-0 border border-slate-100">
            <img class="w-full h-full object-contain group-hover:scale-110 transition-transform duration-500" src="https://lh3.googleusercontent.com/aida-public/AB6AXuCxm1rxv3qo01n6uWSErlwEPER2LMQWk_NMzMPr6gQu6vwmL3NXj5mkXBZ30xTUOrPC-uOIDYFWZTE9TpYuZluilp-NsVIO_cpke7plo-hWJNXwMSll4LmqwR_GbR2q-RG3p6AgO76aTEuDH6kkzWIBTa_bBUQQF4s21ss4RTPkXaRFDYT4u6ZMDWvWLYHRQWUHnoLArawg2ysFX3j2WRStQFxrW4DUWZUZ1MljWeypUR_CLqtSQwVZnaQHD8GDXFZOX-1YdfPpAbQE"/>
          </div>
          <div class="flex-1">
            <h4 class="text-sm font-black text-blue-950">MacBook Pro 14" M3 Pro - Space Black</h4>
            <p class="text-[10px] font-bold text-slate-400 mt-1 uppercase tracking-widest">18GB RAM / 512GB SSD</p>
          </div>
          <div class="text-right">
            <p class="text-lg font-black text-blue-950">48.990.000đ</p>
            <p class="text-[10px] font-black text-slate-400 uppercase tracking-widest">Số lượng: 01</p>
          </div>
        </div>
        <div class="mt-8 flex flex-col items-end gap-3">
          <div class="flex justify-between w-full md:w-72 text-sm font-bold text-slate-400">
            <span>Tạm tính:</span>
            <span class="text-blue-950">48.990.000đ</span>
          </div>
          <div class="flex justify-between w-full md:w-72 text-sm font-bold text-slate-400">
            <span>Vận chuyển:</span>
            <span class="text-green-600">Miễn phí</span>
          </div>
          <div class="flex justify-between w-full md:w-72 pt-4 border-t border-slate-100">
            <span class="text-lg font-black text-blue-950">Tổng cộng:</span>
            <span class="text-2xl font-black text-orange-500">48.990.000đ</span>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>
