<script setup lang="ts">
import AdminLayout from '../layouts/AdminLayout.vue'

const orders = [
  { id: '#ORD-8829', customer: 'Nguyễn Văn Khải', date: '26/04/2024', total: '45,900,000 đ', status: 'Chờ duyệt', statusClass: 'bg-orange-50 text-orange-600' },
  { id: '#ORD-8828', customer: 'Trần Mỹ Linh', date: '25/04/2024', total: '32,400,000 đ', status: 'Đang giao', statusClass: 'bg-blue-50 text-blue-600' },
  { id: '#ORD-8827', customer: 'Lê Hoàng Minh', date: '25/04/2024', total: '16,900,000 đ', status: 'Thành công', statusClass: 'bg-green-50 text-green-600' }
]

const stats = [
  { label: 'Tổng đơn hàng', value: '1,284', icon: 'shopping_bag' },
  { label: 'Đang xử lý', value: '42', icon: 'pending_actions' },
  { label: 'Doanh thu tháng', value: '850.4M', icon: 'payments' }
]
</script>

<template>
  <AdminLayout>
    <div class="space-y-10">
      <!-- Header -->
      <div class="flex justify-between items-end">
        <div>
          <h2 class="text-3xl font-black text-blue-950 uppercase tracking-tight">Quản lý đơn hàng</h2>
          <p class="text-[10px] font-black text-slate-400 uppercase tracking-widest mt-2">Theo dõi và cập nhật trạng thái đơn hàng thời gian thực</p>
        </div>
        <button class="px-8 py-4 bg-white border-2 border-slate-100 text-blue-950 font-black text-[10px] uppercase tracking-widest rounded-2xl hover:bg-slate-50 transition-all flex items-center gap-3">
          <span class="material-symbols-outlined text-sm">file_download</span>
          Xuất báo cáo
        </button>
      </div>

      <!-- Quick Stats -->
      <div class="grid grid-cols-1 md:grid-cols-3 gap-8">
        <div v-for="s in stats" :key="s.label" class="bg-white p-8 rounded-[2.5rem] border border-slate-100 shadow-sm flex items-center gap-6 group hover:shadow-xl hover:shadow-slate-200/50 transition-all">
          <div class="w-14 h-14 bg-slate-50 rounded-2xl flex items-center justify-center text-slate-300 group-hover:bg-blue-950 group-hover:text-white transition-all duration-500">
            <span class="material-symbols-outlined text-2xl">{{ s.icon }}</span>
          </div>
          <div>
            <p class="text-[10px] font-black text-slate-400 uppercase tracking-widest mb-1">{{ s.label }}</p>
            <p class="text-2xl font-black text-blue-950 tracking-tight">{{ s.value }}</p>
          </div>
        </div>
      </div>

      <!-- Order Table -->
      <div class="bg-white rounded-[3rem] border border-slate-100 shadow-sm overflow-hidden">
        <div class="px-10 py-8 border-b border-slate-50 flex justify-between items-center bg-slate-50/30">
          <div class="flex gap-4">
            <button class="px-6 py-2 bg-blue-950 text-white rounded-xl text-[10px] font-black uppercase tracking-widest">Tất cả</button>
            <button class="px-6 py-2 text-slate-400 hover:text-blue-950 rounded-xl text-[10px] font-black uppercase tracking-widest transition-colors">Chờ duyệt</button>
            <button class="px-6 py-2 text-slate-400 hover:text-blue-950 rounded-xl text-[10px] font-black uppercase tracking-widest transition-colors">Đang giao</button>
          </div>
          <span class="material-symbols-outlined text-slate-300 hover:text-blue-950 cursor-pointer transition-colors">filter_list</span>
        </div>
        <div class="overflow-x-auto">
          <table class="w-full text-left">
            <thead>
              <tr class="bg-slate-50/50">
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Mã đơn</th>
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Khách hàng</th>
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Ngày đặt</th>
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Tổng tiền</th>
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Trạng thái</th>
                <th class="px-10 py-6"></th>
              </tr>
            </thead>
            <tbody class="divide-y divide-slate-50">
              <tr v-for="o in orders" :key="o.id" class="group hover:bg-slate-50/50 transition-colors">
                <td class="px-10 py-6 font-black text-blue-950 tracking-wider text-xs">{{ o.id }}</td>
                <td class="px-10 py-6">
                  <span class="text-xs font-black text-blue-950 uppercase tracking-widest">{{ o.customer }}</span>
                </td>
                <td class="px-10 py-6 text-[10px] font-bold text-slate-400 uppercase tracking-widest">{{ o.date }}</td>
                <td class="px-10 py-6 font-black text-blue-950 text-xs">{{ o.total }}</td>
                <td class="px-10 py-6">
                  <span class="px-4 py-1.5 rounded-full text-[8px] font-black uppercase tracking-widest shadow-sm" :class="o.statusClass">{{ o.status }}</span>
                </td>
                <td class="px-10 py-6 text-right">
                  <button class="text-slate-300 hover:text-blue-950 transition-colors">
                    <span class="material-symbols-outlined">visibility</span>
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </AdminLayout>
</template>
