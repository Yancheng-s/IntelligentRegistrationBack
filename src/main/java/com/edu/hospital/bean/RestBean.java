package com.edu.hospital.bean;

import java.util.List;
import java.util.Map;

/**
 * 回复状态Bean：包括数据
 */
public class RestBean {
	private List<Map<String,Object>> list;//对应查询数据
	private int totalCount;//对应查询总条目数量
	private String msg;//前端显示内容
	private String status;//前端状态字符串：success/warning/info/error
	public RestBean() {
		super();
	}
	public RestBean(List<Map<String, Object>> list, int totalCount, String msg, String status) {
		super();
		this.list = list;
		this.totalCount = totalCount;
		this.msg = msg;
		this.status = status;
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + totalCount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RestBean other = (RestBean) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalCount != other.totalCount)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RestBean [list=" + list + ", totalCount=" + totalCount + ", msg=" + msg + ", status=" + status + "]";
	}
	
}
