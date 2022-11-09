<template>
  <div>
    <h1>Matéria Prima</h1>
    <div class="container-fluid">
      <div class="row d-flex justify-content-around align-items-center">
        <div class="col-12 col-lg-3">
          <FormRawMaterial />
        </div>
        <div class="col-12 col-lg-8">
          <RawMaterialTable />
        </div>
        >
      </div>
    </div>
  </div>
</template>

<script>
import FormRawMaterial from '~/components/RawMaterial/FormRawMaterial.vue'
import RawMaterialTable from '~/components/RawMaterial/TableRawMaterial.vue'
export default {
  name: 'RawMaterialsPage',
  components: { RawMaterialTable, FormRawMaterial },

  created() {
    this.$store.dispatch('rawMaterials/getRawMaterials')
  },
}
</script>
