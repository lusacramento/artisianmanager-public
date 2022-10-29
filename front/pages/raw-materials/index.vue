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
  data() {
    return {}
  },
  created() {
    this.$store.dispatch('rawMaterials/getRawMaterials')
  },
  // methods: {
  //   async getRawMaterial() {
  //     const response = await this.$axios.$get(
  //       'http://localhost:8080/api/raw-material/'
  //     )
  //     this.rawMaterials = response
  //   },

  //   async getCount() {
  //     const response = await this.$axios.$get(
  //       'http://localhost:8080/api/raw-material/count'
  //     )
  //     this.count = response
  //   },

  //   async postRawMaterial(data) {
  //     await this.$axios.$post(
  //       'http://localhost:8080/api/raw-material/insert',
  //       data
  //     )
  //   },

  //   receiveRawMaterial(rawMaterial) {
  //     this.postRawMaterial(rawMaterial)
  //   },
  // },
}
</script>

<style></style>
