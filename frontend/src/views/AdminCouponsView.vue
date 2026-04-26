<script setup lang="ts">
import AdminLayout from '../layouts/AdminLayout.vue'

const activeCoupons = [
  { code: 'LUXE2024', name: 'Ưu đãi năm mới', type: 'GIẢM 20%', range: '01/01/2024 - 31/12/2024', used: 325, total: 500, color: 'bg-blue-950' },
  { code: 'TECHSALE', name: 'Tuần lễ công nghệ', type: 'GIẢM 500K', range: '15/05/2024 - 22/05/2024', used: 12, total: 100, color: 'bg-blue-950' },
  { code: 'VIPWELCOME', name: 'Thành viên mới', type: 'GIẢM 15%', range: 'Sắp hết hạn: 3 ngày', used: 950, total: 1000, color: 'bg-red-500' }
]

const stats = [
  { label: 'Đang hoạt động', value: '12', sub: '+2 mã mới tuần này', icon: 'trending_up', color: 'text-green-600 bg-green-50' },
  { label: 'Đã sử dụng', value: '1,482', sub: 'Trong 30 ngày qua', icon: 'history', color: 'text-blue-600 bg-blue-50' },
  { label: 'Doanh số giảm', value: '45.2M', sub: 'VND', icon: 'monetization_on', color: 'text-orange-600 bg-orange-50' }
]
</script>

<template>
  <AdminLayout>
    <div class="space-y-10">
      <div class="flex justify-between items-end">
        <div>
          <h2 class="text-3xl font-black text-blue-950 uppercase tracking-tight">Mã giảm giá</h2>
          <p class="text-[10px] font-black text-slate-400 uppercase tracking-widest mt-2">Thiết lập và theo dõi các chương trình ưu đãi dành cho khách hàng</p>
        </div>
        <button class="px-8 py-4 bg-white border-2 border-slate-100 text-blue-950 font-black text-[10px] uppercase tracking-widest rounded-2xl hover:bg-slate-50 transition-all flex items-center gap-3">
          <span class="material-symbols-outlined text-sm">file_download</span>
          Xuất báo cáo
        </button>
      </div>

      <div class="grid grid-cols-12 gap-10">
        <!-- Left: List -->
        <div class="col-span-12 lg:col-span-8 flex flex-col gap-10">
          <!-- Stats -->
          <div class="grid grid-cols-1 md:grid-cols-3 gap-6">
            <div v-for="s in stats" :key="s.label" class="bg-white p-8 rounded-[2.5rem] border border-slate-100 shadow-sm group hover:shadow-xl hover:shadow-slate-200/50 transition-all">
              <p class="text-[10px] font-black text-slate-400 uppercase tracking-[0.2em] mb-3">{{ s.label }}</p>
              <h3 class="text-3xl font-black text-blue-950">{{ s.value }}</h3>
              <div class="mt-6 flex items-center gap-2 text-[10px] font-black uppercase tracking-widest" :class="s.color.split(' ')[0]">
                <span class="material-symbols-outlined text-xs">{{ s.icon }}</span>
                {{ s.sub }}
              </div>
            </div>
          </div>

          <!-- Table -->
          <div class="bg-white rounded-[3rem] border border-slate-100 shadow-sm overflow-hidden">
            <div class="px-10 py-8 border-b border-slate-100 bg-slate-50/30 flex justify-between items-center">
              <h3 class="text-lg font-black text-blue-950 uppercase tracking-tight">Mã đang hoạt động</h3>
              <span class="material-symbols-outlined text-slate-300 hover:text-blue-950 cursor-pointer transition-colors">filter_list</span>
            </div>
            <div class="overflow-x-auto">
              <table class="w-full text-left">
                <thead>
                  <tr class="bg-slate-50/50">
                    <th class="px-10 py-5 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Mã Code</th>
                    <th class="px-10 py-5 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Loại</th>
                    <th class="px-10 py-5 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Thời hạn</th>
                    <th class="px-10 py-5 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Sử dụng</th>
                    <th class="px-10 py-5 text-right"></th>
                  </tr>
                </thead>
                <tbody class="divide-y divide-slate-50">
                  <tr v-for="c in activeCoupons" :key="c.code" class="group hover:bg-slate-50/50 transition-colors">
                    <td class="px-10 py-6">
                      <p class="text-sm font-black text-blue-950 tracking-wider font-mono">{{ c.code }}</p>
                      <p class="text-[8px] font-bold text-slate-400 uppercase tracking-widest mt-1">{{ c.name }}</p>
                    </td>
                    <td class="px-10 py-6">
                      <span class="inline-flex items-center px-3 py-1 rounded-lg bg-blue-50 text-blue-950 text-[8px] font-black uppercase tracking-widest border border-blue-100">{{ c.type }}</span>
                    </td>
                    <td class="px-10 py-6">
                      <p class="text-[10px] font-bold uppercase tracking-widest" :class="c.range.includes('hết hạn') ? 'text-red-500' : 'text-slate-400'">{{ c.range }}</p>
                    </td>
                    <td class="px-10 py-6">
                      <div class="flex items-center gap-4">
                        <div class="w-24 h-1.5 bg-slate-100 rounded-full overflow-hidden">
                          <div class="h-full rounded-full transition-all duration-1000" :class="c.color" :style="{ width: (c.used / c.total * 100) + '%' }"></div>
                        </div>
                        <span class="text-[10px] font-black text-blue-950">{{ c.used }}/{{ c.total }}</span>
                      </div>
                    </td>
                    <td class="px-10 py-6 text-right">
                      <div class="flex justify-end gap-4 opacity-0 group-hover:opacity-100 transition-opacity">
                        <button class="text-blue-950 hover:text-blue-700 transition-colors">
                          <span class="material-symbols-outlined text-sm">edit</span>
                        </button>
                        <button class="text-red-500 hover:text-red-700 transition-colors">
                          <span class="material-symbols-outlined text-sm">delete</span>
                        </button>
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>

        <!-- Right: Create Form -->
        <div class="col-span-12 lg:col-span-4 flex flex-col gap-8">
          <div class="bg-white rounded-[2.5rem] border border-slate-100 shadow-2xl shadow-slate-200/50 p-10 lg:sticky lg:top-10">
            <h3 class="text-lg font-black text-blue-950 mb-10 flex items-center gap-3">
              <span class="material-symbols-outlined text-orange-500" style="font-variation-settings: 'FILL' 1">add_circle</span>
              Tạo mã mới
            </h3>
            <form class="space-y-8">
              <div>
                <label class="block text-[10px] font-black text-slate-400 uppercase tracking-widest mb-3">Tên mã (Coupon Code)</label>
                <input type="text" class="w-full bg-slate-50 border-none px-6 py-4 rounded-xl font-black text-blue-950 uppercase tracking-wider font-mono focus:ring-4 focus:ring-blue-100 transition-all" placeholder="Vd: LUXE_SUMMER24">
              </div>
              <div class="grid grid-cols-2 gap-4">
                <div>
                  <label class="block text-[10px] font-black text-slate-400 uppercase tracking-widest mb-3">Loại giảm</label>
                  <select class="w-full bg-slate-50 border-none px-4 py-4 rounded-xl font-black text-blue-950 text-xs focus:ring-4 focus:ring-blue-100 transition-all appearance-none cursor-pointer">
                    <option>Phần trăm (%)</option>
                    <option>Số tiền (₫)</option>
                  </select>
                </div>
                <div>
                  <label class="block text-[10px] font-black text-slate-400 uppercase tracking-widest mb-3">Giá trị</label>
                  <input type="number" class="w-full bg-slate-50 border-none px-4 py-4 rounded-xl font-black text-blue-950 focus:ring-4 focus:ring-blue-100 transition-all" placeholder="0">
                </div>
              </div>
              <div>
                <label class="block text-[10px] font-black text-slate-400 uppercase tracking-widest mb-3">Hạn sử dụng</label>
                <input type="date" class="w-full bg-slate-50 border-none px-6 py-4 rounded-xl font-black text-blue-950 focus:ring-4 focus:ring-blue-100 transition-all">
              </div>
              <button type="submit" class="w-full py-5 bg-orange-500 text-white font-black text-[10px] uppercase tracking-[0.2em] rounded-2xl shadow-xl shadow-orange-500/30 hover:bg-orange-600 active:scale-95 transition-all flex items-center justify-center gap-3">
                <span class="material-symbols-outlined text-sm">bolt</span>
                Kích hoạt mã
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </AdminLayout>
</template>
