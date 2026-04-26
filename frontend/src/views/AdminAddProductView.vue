<script setup lang="ts">
import { ref } from 'vue'
import AdminLayout from '../layouts/AdminLayout.vue'

const specs = ref([
  { label: 'Vi xử lý (CPU)', value: 'Apple M3 Max 14-core' },
  { label: 'Bộ nhớ RAM', value: '36GB Unified Memory' },
  { label: 'Màn hình', value: '14.2-inch Liquid Retina XDR' }
])

const addSpec = () => {
  specs.value.push({ label: '', value: '' })
}

const removeSpec = (index: number) => {
  specs.value.splice(index, 1)
}

const images = ref([
  'https://lh3.googleusercontent.com/aida-public/AB6AXuABaAvU5qtRYMjeiuqOLEsOENoGsCI11zkOZq-oTPmXF3NGqXNiNA3gb74l-LFuWfrGzGPWCbyVaRcuEr07kfo0Nqb7ckubhUMkclMc4nNt0M8JPjQn-Plq2GlS_ZOnVSYD208JZszdglhjyxCsT5LF3QDFYwDmNeyHGmJm5ZjpbTmn7xar3B-36tnkJ2YDQZ8xpCG4GQ9KYf7Mj_7pmOVHBWnyCMyw7yU1JnPw6fmHsexWd0TBWZSXgTqW14NgyQuLCY7I1Veh664V',
  'https://lh3.googleusercontent.com/aida-public/AB6AXuDK3OVw72wTJ9lbnUInBsKnarzTPi_KQ-368638ZCAag7y35DwLSNVCCp-SC9Ox09_jogpxGNuqT6c0C55IZeDy6GYp3dqmLjVrxgVOS3F9My84Sk9iELgCs2GWqSKOVWh_Jg-fRGLbf1JeIUNv6fT3tz_h3wPz5EoP-GSRVjivctxDn_taEkiimkNar6H5BJK73VGSTgWfvLgDsJ1efmt9W_Wxh4FZHtAsnjaeI0bIjGVXFoaKLqTah33kZ2qClFSxC2KNhJxCoq8F'
])
</script>

<template>
          <p class="text-[10px] font-bold text-slate-400 mt-4 leading-relaxed uppercase tracking-widest">Sản phẩm sẽ hiển thị trên trang chủ ngay sau khi lưu.</p>
        </section>
      </div>
    </div>
  </div>
</template>
