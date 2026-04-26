<script setup lang="ts">
import AdminLayout from '../layouts/AdminLayout.vue'

const stats = [
  { label: 'Tổng doanh thu', value: '2,450,000,000 đ', trend: '↑ 12.5%', trendColor: 'text-green-600 bg-green-50', icon: 'payments' },
  { label: 'Số đơn hàng mới', value: '156', trend: '↑ 8.2%', trendColor: 'text-green-600 bg-green-50', icon: 'shopping_bag' },
  { label: 'Tổng khách hàng', value: '1,204', trend: '↑ 4.1%', trendColor: 'text-green-600 bg-green-50', icon: 'person_add' },
  { label: 'Hết hàng', value: '8', trend: 'Cần nhập', trendColor: 'text-red-600 bg-red-50', icon: 'inventory_2' }
]

const recentOrders = [
  { id: '#ORD-8829', customer: 'Nguyễn Văn Khải', avatar: 'https://i.pravatar.cc/150?u=khai', product: 'MacBook Pro 14"', status: 'Chờ duyệt', statusClass: 'bg-orange-50 text-orange-600', amount: '45,900,000 đ' },
  { id: '#ORD-8828', customer: 'Trần Mỹ Linh', avatar: 'https://i.pravatar.cc/150?u=linh', product: 'iPhone 15 Pro Max', status: 'Đang giao', statusClass: 'bg-blue-50 text-blue-600', amount: '32,400,000 đ' },
  { id: '#ORD-8827', customer: 'Lê Hoàng Minh', avatar: 'https://i.pravatar.cc/150?u=minh', product: 'iPad Air M2', status: 'Thành công', statusClass: 'bg-green-50 text-green-600', amount: '16,900,000 đ' },
  { id: '#ORD-8826', customer: 'Phạm Thu Thảo', avatar: 'https://i.pravatar.cc/150?u=thao', product: 'Sony WH-1000XM5', status: 'Đã hủy', statusClass: 'bg-red-50 text-red-600', amount: '8,450,000 đ' }
]

const chartData = [
  { day: 'Thứ 2', height: '40%', value: '150M' },
  { day: 'Thứ 3', height: '55%', value: '220M' },
  { day: 'Thứ 4', height: '75%', value: '310M' },
  { day: 'Thứ 5', height: '60%', value: '250M' },
  { day: 'Thứ 6', height: '90%', value: '420M' },
  { day: 'Thứ 7', height: '82%', value: '380M', active: true },
  { day: 'Chủ Nhật', height: '35%', value: '120M' }
]
</script>

<template>
  <AdminLayout>
    <div class="space-y-10">
      <!-- Stats Grid -->
      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8">
        <div v-for="s in stats" :key="s.label" class="bg-white p-8 rounded-[2.5rem] border border-slate-100 shadow-sm flex flex-col gap-6 group hover:shadow-2xl hover:shadow-slate-200/50 transition-all">
          <div class="flex justify-between items-start">
            <div class="w-12 h-12 bg-blue-950 rounded-2xl flex items-center justify-center text-white shadow-lg shadow-blue-950/20 group-hover:scale-110 transition-transform">
              <span class="material-symbols-outlined text-xl" style="font-variation-settings: 'FILL' 1">{{ s.icon }}</span>
            </div>
            <span class="text-[10px] font-black px-3 py-1.5 rounded-full uppercase tracking-widest shadow-sm" :class="s.trendColor">{{ s.trend }}</span>
          </div>
          <div>
            <p class="text-[10px] font-black text-slate-400 uppercase tracking-[0.2em] mb-2">{{ s.label }}</p>
            <p class="text-2xl font-black text-blue-950">{{ s.value }}</p>
          </div>
        </div>
      </div>

      <!-- Main Split -->
      <div class="grid grid-cols-1 lg:grid-cols-3 gap-10">
        <!-- Revenue Chart -->
        <div class="lg:col-span-2 bg-white p-10 rounded-[3rem] border border-slate-100 shadow-sm">
          <div class="flex justify-between items-start mb-12">
            <div>
              <h2 class="text-xl font-black text-blue-950 uppercase tracking-tight">Phân tích doanh thu</h2>
              <p class="text-[10px] font-black text-slate-400 uppercase tracking-widest mt-2">Thống kê 7 ngày gần nhất</p>
            </div>
            <div class="flex gap-3">
              <button class="px-6 py-3 bg-slate-50 text-blue-950 font-black text-[10px] uppercase tracking-widest rounded-xl hover:bg-slate-100 transition-all border border-slate-100">Tải báo cáo</button>
              <button class="px-6 py-3 bg-blue-950 text-white font-black text-[10px] uppercase tracking-widest rounded-xl shadow-lg shadow-blue-950/20">Tuần này</button>
            </div>
          </div>
          
          <div class="h-80 flex items-end justify-between px-4 gap-6">
            <div v-for="bar in chartData" :key="bar.day" class="flex flex-col items-center flex-1 group">
              <div class="w-full relative rounded-t-2xl transition-all duration-500 cursor-pointer"
                   :class="bar.active ? 'bg-orange-500 shadow-xl shadow-orange-500/30' : 'bg-blue-950/10 hover:bg-blue-950/20'"
                   :style="{ height: bar.height }">
                <div class="absolute -top-10 left-1/2 -translate-x-1/2 bg-blue-950 text-white text-[8px] font-black px-2 py-1 rounded-lg opacity-0 group-hover:opacity-100 transition-opacity shadow-lg uppercase tracking-widest">{{ bar.value }}</div>
              </div>
              <span class="text-[9px] font-black uppercase tracking-widest mt-5" :class="bar.active ? 'text-blue-950' : 'text-slate-300'">{{ bar.day }}</span>
            </div>
          </div>
        </div>

        <!-- Featured Products -->
        <div class="bg-white p-10 rounded-[3rem] border border-slate-100 shadow-sm flex flex-col">
          <div class="flex justify-between items-center mb-10">
            <h2 class="text-lg font-black text-blue-950 uppercase tracking-tight">Bán chạy nhất</h2>
            <button class="text-[10px] font-black text-orange-500 uppercase tracking-widest hover:underline">Tất cả</button>
          </div>
          <div class="space-y-6 flex-1">
            <div v-for="p in [
              { name: 'MacBook Pro M3 Max', sales: '24 đơn hàng', price: '45.9M', trend: 'HOT', icon: 'laptop_mac' },
              { name: 'iPhone 15 Pro Max', sales: '18 đơn hàng', price: '32.4M', trend: 'NEW', icon: 'smartphone' },
              { name: 'Apple Watch Ultra 2', sales: '12 đơn hàng', price: '21.5M', trend: 'UP', icon: 'watch' }
            ]" :key="p.name" class="flex items-center gap-5 p-4 hover:bg-slate-50 rounded-2xl transition-all cursor-pointer group">
              <div class="w-14 h-14 bg-slate-50 rounded-2xl flex items-center justify-center text-slate-300 group-hover:text-blue-950 transition-colors">
                <span class="material-symbols-outlined text-2xl">{{ p.icon }}</span>
              </div>
              <div class="flex-1 overflow-hidden">
                <p class="text-xs font-black text-blue-950 uppercase tracking-widest truncate">{{ p.name }}</p>
                <p class="text-[8px] font-bold text-slate-400 uppercase tracking-widest mt-1">{{ p.sales }}</p>
              </div>
              <div class="text-right">
                <p class="text-xs font-black text-blue-950 tracking-tight">{{ p.price }}</p>
                <p class="text-[8px] font-black text-green-500 tracking-widest mt-1">{{ p.trend }}</p>
              </div>
            </div>
          </div>
          <button class="mt-8 w-full py-5 border-2 border-dashed border-slate-100 rounded-2xl text-slate-300 text-[10px] font-black uppercase tracking-widest hover:border-blue-950 hover:text-blue-950 transition-all active:scale-95">Quản lý kho hàng</button>
        </div>
      </div>

      <!-- Recent Orders -->
      <div class="bg-white rounded-[3rem] border border-slate-100 shadow-sm overflow-hidden">
        <div class="px-10 py-8 border-b border-slate-50 flex justify-between items-center bg-slate-50/30">
          <h3 class="text-lg font-black text-blue-950 uppercase tracking-tight">Đơn hàng cần xử lý</h3>
          <button class="text-[10px] font-black text-blue-950 uppercase tracking-widest flex items-center gap-2 hover:gap-3 transition-all group">
            Xem tất cả 
            <span class="material-symbols-outlined text-sm">arrow_forward</span>
          </button>
        </div>
        <div class="overflow-x-auto">
          <table class="w-full text-left">
            <thead>
              <tr class="bg-slate-50/50">
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Mã đơn</th>
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Khách hàng</th>
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Sản phẩm</th>
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Trạng thái</th>
                <th class="px-10 py-6 text-right text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Tổng tiền</th>
              </tr>
            </thead>
            <tbody class="divide-y divide-slate-50">
              <tr v-for="o in recentOrders" :key="o.id" class="hover:bg-slate-50/50 transition-colors group">
                <td class="px-10 py-6">
                  <span class="text-xs font-black text-blue-950 tracking-wider">{{ o.id }}</span>
                </td>
                <td class="px-10 py-6">
                  <div class="flex items-center gap-4">
                    <img :src="o.avatar" class="w-10 h-10 rounded-full border-2 border-slate-100" alt="Avatar">
                    <span class="text-xs font-black text-blue-950 uppercase tracking-widest">{{ o.customer }}</span>
                  </div>
                </td>
                <td class="px-10 py-6">
                  <div class="flex items-center gap-3">
                    <span class="material-symbols-outlined text-slate-300 text-sm">laptop</span>
                    <span class="text-[10px] font-bold text-slate-400 uppercase tracking-widest">{{ o.product }}</span>
                  </div>
                </td>
                <td class="px-10 py-6">
                  <span class="px-4 py-1.5 rounded-full text-[8px] font-black uppercase tracking-widest shadow-sm" :class="o.statusClass">{{ o.status }}</span>
                </td>
                <td class="px-10 py-6 text-right">
                  <span class="text-xs font-black text-blue-950">{{ o.amount }}</span>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </AdminLayout>
</template>
