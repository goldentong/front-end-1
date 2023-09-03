import request from '@/utils/request'

// 分页查询人员档案
export function getPageList(params) {
  return request({
    url: '/document',
    method: 'get',
    params: params
  })
}

// 新增或编辑人员档案
export function saveOrUpdateData(data) {
  return request({
    url: '/document',
    method: 'post',
    data: data
  })
}

// 删除人员档案
export function deleteData(id) {
  return request({
    url: '/document/' + id,
    method: 'delete'
  })
}
