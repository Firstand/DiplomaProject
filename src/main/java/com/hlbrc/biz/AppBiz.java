package com.hlbrc.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlbrc.entity.Address;
import com.hlbrc.entity.AddressExample;
import com.hlbrc.entity.City;
import com.hlbrc.entity.District;
import com.hlbrc.entity.Privince;
import com.hlbrc.enums.AppEnum;
import com.hlbrc.mapper.IAddressMapper;
import com.hlbrc.mapper.ICityMapper;
import com.hlbrc.mapper.IDistrictMapper;
import com.hlbrc.mapper.IPrivinceMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * app请求处理逻辑层
 * @author ZY
 *
 */
@Service("AppBiz")
@Transactional(readOnly = true)
public class AppBiz {
	@Autowired
	private IAddressMapper address_mapper;
	@Autowired
	private IPrivinceMapper privince_mapper;
	@Autowired
	private ICityMapper city_mapper;
	@Autowired
	private IDistrictMapper district_mapper;
	//查询用户地址
	public String queryAddress(AddressExample address) {
		List<Address> List_address = address_mapper.selectByExample(address);
		JSONArray array = new JSONArray();
		JSONObject obj = null;
		for(Address a:List_address) {
			obj = new JSONObject();
			District district = district_mapper.selectByPrimaryKey(a.getDisId());
			City city = city_mapper.selectByPrimaryKey(district.getCitId());
			Privince privince = privince_mapper.selectByPrimaryKey(city.getProId());
			obj.accumulate("RecieveAddressID", a.getAddressid());
			obj.accumulate("RecieveName", a.getName());
			obj.accumulate("MobilePhone", a.getTel());
			obj.accumulate("RecieverProvinceID", privince.getProId());
			obj.accumulate("RecieverCityID", city.getCitId());
			obj.accumulate("RecieverCountyID", district.getDisId());
			obj.accumulate("RecieverAddress", a.getAddressDetail());
			obj.accumulate("Remark", a.getRemark());
			obj.accumulate("CreateTime2", a.getCreatTime());
			obj.accumulate("CustomerEnterID", 126);
			if(a.getIsDefault()==AppEnum.ADDRESS_DEL) {
				obj.accumulate("Disable", 1);
			}
			else {
				obj.accumulate("Disable", 0);
			}
			obj.accumulate("RecieverProvinceName", privince.getProName());
			obj.accumulate("RecieverCityName", city.getCitName());
			obj.accumulate("RecieverCountyName", district.getDisName());
			obj.accumulate("PostCode", a.getPastTode());
			obj.accumulate("IsDefault", a.getIsDefault());
			array.add(obj);
		}
		obj = new JSONObject();
		obj.accumulate("RecieveAddressList", array);
		return obj.toString();
	}
	//添加用户地址
	@Transactional(rollbackFor=Throwable.class)
	public void insertAddress() {
		
	}
	//修改用户地址
	@Transactional(rollbackFor=Throwable.class)
	public void updateAddress() {
		
	}
	//删除用户地址（假删除）
	@Transactional(rollbackFor=Throwable.class)
	public void deleteAddress() {
		
	}
}
