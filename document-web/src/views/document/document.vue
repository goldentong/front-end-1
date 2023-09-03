<template>
  <div class="app-container">
    <div class="tb" style="height: 100%">
      <div class="main tb">
        <div class="lr between">
          <div style="display: flex;justify-content: space-between;">
            <el-input style="width: 217px;" v-model="table.query.keyWord" placeholder="Please enter keywords for query" clearable
                      suffix-icon="el-icon-search"/>
          </div>
        </div>
        <div class="main" style="margin-top: 20px;">
          <el-table :data="table.data" height="650px" border
                    :header-cell-style="{background:'#fafafa',color:'#000000'}" v-loading="tableLoading">
            <template slot="empty">
              <p>no data</p>
            </template>
            <el-table-column show-overflow-tooltip fixed="left" label="Serial Number" type="index" width="150"
                             align="center"/>
            <el-table-column show-overflow-tooltip label="name" align="center"
                             prop="name"></el-table-column>
            <el-table-column show-overflow-tooltip label="age" align="center"
                             prop="backInfo"></el-table-column>
            <el-table-column show-overflow-tooltip label="gender" align="center"
                             prop="backInfo"></el-table-column>
            <el-table-column show-overflow-tooltip label="roomNumber" align="center"
                             prop="backInfo"></el-table-column>
          </el-table>
        </div>
        <div class="lr end" style="margin-top: 20px;">
          <el-pagination :total="table.total" :page-size="table.query.size" :current-page="table.query.page"
                         layout="prev, pager, next" @current-change="currentPageChange"/>
        </div>
      </div>
    </div>
  </div>
</template>
<script>

import {getPageList} from "@/api/document";

export default {
  data() {
    return {
      table: {
        query: {
          page: 1,
          size: 10,
          keyWord: ''
        },
        total: 0,
        data: []
      },
      documentDialog: {
        formData: {
          name: '',
          age: '',
          gender: '',
          roomNumber: '',
          pictureUrl: '',
          backInfo: '',
          languageIds: '',
          languageNames: '',
          favoriteIds: '',
          favoriteNames: ''
        },
        visible: false
      },
      rules: {
        name: [
          {trigger: 'change', required: true, message: 'Please enter ResidentName'}
        ],
        age: [
          {trigger: 'change', required: true, message: 'Please enter Age'}
        ],
        gender: [
          {trigger: 'change', required: true, message: 'Please enter Gender'}
        ],
        roomNumber: [
          {trigger: 'change', required: true, message: 'Please enter RoomNumber'}
        ],
        pictureUrl: [
          {trigger: 'change', required: true, message: 'Please upload resident photos'}
        ],
        backInfo: [
          {trigger: 'blur', required: true, message: 'Please enter BackgroundInformation'}
        ],
        languageIds: [
          {trigger: 'blur', required: true, message: 'Please select Language'}
        ],
        favoriteIds: [
          {trigger: 'blur', required: true, message: 'Please select Favorite'}
        ]
      },
      loading: false,
      tableLoading: false,
      isEdit: false,
      isInfo: false,
      imageList: [],
      languages: [
        {
          id: 1,
          name: 'English'
        },
        {
          id: 2,
          name: 'Chinese'
        },
        {
          id: 3,
          name: 'Japanese'
        },
        {
          id: 4,
          name: 'Korean'
        }
      ],
      favorites: [
        {
          id: 1,
          name: 'Music'
        },
        {
          id: 2,
          name: 'Movie'
        },
        {
          id: 3,
          name: 'Game'
        },
        {
          id: 4,
          name: 'Food'
        }
      ],
      gender: [
        {
          id: 1,
          name: 'man'
        },
        {
          id: 2,
          name: 'woman'
        }
      ]
    }
  },
  mounted() {
  },
  methods: {
    // 页码变更
    currentPageChange(page) {
      this.table.query.page = page
      this.search(false)
    }
  }
}
</script>

<style scoped>
</style>
