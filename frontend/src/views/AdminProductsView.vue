<script setup lang="ts">
import AdminLayout from '../layouts/AdminLayout.vue'

const products = [
  { id: 1, name: 'Luxe Titan Pro 15', category: 'Smartphones', price: '32.990.000₫', stock: 45, status: 'Active', image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuAjSwW5HVA4MX9Dh7s-pGbcax_V-2vBDznx4AfSv1S3RjVP3UvRzceaGTEbaK_ZubX9tqwZA1nfjD5hwB1iV8dIjxAWo4utZ8ljXdl17K-Wp1Lp0qYme069JtsWEKIYPmV_v20IqVxBQcIR05mAE5ik0LddamJlN6wgZNd148ox53hy7MmZANE2sAmE6OQ4eD5EZjxmYdncqahKrt4M8hnrMVPoizsX0ugQCINMqvGREOjnEW5RQTIxU84mvFo3FA4OfmT4HRlg61FH' },
  { id: 2, name: 'Nebula Fold X4', category: 'Smartphones', price: '44.990.000₫', stock: 12, status: 'Active', image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuACmY9NBIxFtWoammxsZCSYUhhvshsiz67uNCi9wtKsCG1WeUxe3SJOpysvdkThwT2Ep8US6YiKspsznR8APu5NC2ABvNc2W8b174iW9CqO81_HlKzsLjLYulYtVTZ1LmjPrcweHm8M2yXyTlvD4dI7oKArqByJmdWKEYT1PMLtlkqXehSgthmUMpK4ffSHzhH6saH3XsF-psqrdOES-o89j7X0YHTJ7ib1mSGnPfC4k1xtJ17JFi8a87d0Yu-bgRK-0iS-aWiQ-a3a' },
  { id: 3, name: 'Zenith Ultra 24', category: 'Smartphones', price: '28.990.000₫', stock: 0, status: 'Out of Stock', image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuDmjkBrwVPmDIbs41VoeZ7LxUxPB9x4c3A-cqJEv_uT9TLHt1fbLHf3bVSaGJjCe-eD00sTyysFn0fzRwEVOvq3cw1Bg7hzyOr-sJ-jkYJjPgnPQjEN4SJO8DdZrJUoNHquGxfNRAc1GT0ArB7_TwNt2SzHT7x1J42Ilz9B9KPvKZQpTXKiitGBArM2ARCkUOLM3PLvEH-JUACntZUgd8EqsHCG1B0UVSfuczgq9SOozxnYkSRENss_TrX_nnZUiG2o4W-4scmQHOWQ' }
]
</script>

<template>
  <AdminLayout>
    <div class="space-y-10">
      <!-- Header Actions -->
      <div class="flex justify-between items-end">
        <div>
          <h2 class="text-3xl font-black text-blue-950 uppercase tracking-tight">Kho sản phẩm</h2>
          <p class="text-[10px] font-black text-slate-400 uppercase tracking-widest mt-2">Tổng cộng 124 sản phẩm đang kinh doanh</p>
        </div>
        <div class="flex gap-4">
          <button class="px-8 py-4 border-2 border-slate-100 text-blue-950 font-black text-[10px] uppercase tracking-widest rounded-2xl hover:bg-slate-50 transition-all">Xuất CSV</button>
          <RouterLink to="/admin/products/add" class="px-8 py-4 bg-orange-500 text-white font-black text-[10px] uppercase tracking-widest rounded-2xl shadow-xl shadow-orange-500/30 hover:bg-orange-600 transition-all flex items-center gap-3">
            <span class="material-symbols-outlined text-sm">add</span>
            Thêm sản phẩm
          </RouterLink>
        </div>
      </div>

      <!-- Filters -->
      <div class="bg-white p-6 rounded-[2rem] border border-slate-100 shadow-sm flex flex-wrap gap-4 items-center">
        <div class="flex-1 min-w-[200px] relative">
          <span class="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-slate-300 text-sm">filter_list</span>
          <select class="w-full bg-slate-50 border-none pl-12 pr-4 py-3 rounded-xl text-xs font-bold text-blue-950 appearance-none cursor-pointer">
            <option>Tất cả danh mục</option>
            <option>Smartphones</option>
            <option>Laptops</option>
            <option>Audio</option>
          </select>
        </div>
        <div class="flex-1 min-w-[200px] relative">
          <span class="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-slate-300 text-sm">sort</span>
          <select class="w-full bg-slate-50 border-none pl-12 pr-4 py-3 rounded-xl text-xs font-bold text-blue-950 appearance-none cursor-pointer">
            <option>Mới nhất</option>
            <option>Giá cao đến thấp</option>
            <option>Giá thấp đến cao</option>
          </select>
        </div>
        <button class="px-8 py-3 bg-blue-950 text-white font-black text-[10px] uppercase tracking-widest rounded-xl">Áp dụng lọc</button>
      </div>

      <!-- Product Table -->
      <div class="bg-white rounded-[3rem] border border-slate-100 shadow-sm overflow-hidden">
        <div class="overflow-x-auto">
          <table class="w-full text-left">
            <thead>
              <tr class="bg-slate-50/50">
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Sản phẩm</th>
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Danh mục</th>
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Giá bán</th>
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Kho hàng</th>
                <th class="px-10 py-6 text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Trạng thái</th>
                <th class="px-10 py-6"></th>
              </tr>
            </thead>
            <tbody class="divide-y divide-slate-50">
              <tr v-for="p in products" :key="p.id" class="group hover:bg-slate-50/50 transition-colors">
                <td class="px-10 py-6">
                  <div class="flex items-center gap-6">
                    <div class="w-16 h-16 rounded-2xl bg-slate-50 p-2 flex items-center justify-center group-hover:scale-110 transition-transform">
                      <img :src="p.image" class="w-full h-full object-contain">
                    </div>
                    <span class="text-xs font-black text-blue-950 uppercase tracking-widest">{{ p.name }}</span>
                  </div>
                </td>
                <td class="px-10 py-6">
                  <span class="text-[10px] font-bold text-slate-400 uppercase tracking-widest">{{ p.category }}</span>
                </td>
                <td class="px-10 py-6">
                  <span class="text-xs font-black text-blue-950 tracking-tight">{{ p.price }}</span>
                </td>
                <td class="px-10 py-6">
                   <div class="flex items-center gap-4">
                    <div class="w-20 h-1.5 bg-slate-100 rounded-full overflow-hidden">
                      <div class="h-full bg-blue-950 rounded-full" :style="{ width: p.stock > 0 ? '65%' : '0%' }"></div>
                    </div>
                    <span class="text-[10px] font-black" :class="p.stock > 0 ? 'text-blue-950' : 'text-red-500'">{{ p.stock }}</span>
                  </div>
                </td>
                <td class="px-10 py-6">
                  <span class="px-4 py-1.5 rounded-full text-[8px] font-black uppercase tracking-widest shadow-sm"
                        :class="p.status === 'Active' ? 'bg-green-50 text-green-600' : 'bg-red-50 text-red-600'">
                    {{ p.status }}
                  </span>
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
        <div class="px-10 py-10 border-t border-slate-50 flex justify-between items-center bg-slate-50/30">
          <p class="text-[10px] font-black text-slate-400 uppercase tracking-widest">Hiển thị 1-10 của 124 sản phẩm</p>
          <div class="flex gap-3">
            <button class="w-12 h-12 flex items-center justify-center rounded-2xl border-2 border-slate-100 text-slate-300 hover:border-blue-950 hover:text-blue-950 transition-all">
              <span class="material-symbols-outlined text-sm">chevron_left</span>
            </button>
            <button class="w-12 h-12 flex items-center justify-center rounded-2xl bg-blue-950 text-white font-black text-[10px] shadow-lg shadow-blue-950/20">1</button>
            <button class="w-12 h-12 flex items-center justify-center rounded-2xl border-2 border-slate-100 text-slate-400 font-black text-[10px] hover:border-blue-950 transition-all">2</button>
            <button class="w-12 h-12 flex items-center justify-center rounded-2xl border-2 border-slate-100 text-slate-300 hover:border-blue-950 hover:text-blue-950 transition-all">
              <span class="material-symbols-outlined text-sm">chevron_right</span>
            </button>
          </div>
        </div>
      </div>
    </div>
  </AdminLayout>
</template>
