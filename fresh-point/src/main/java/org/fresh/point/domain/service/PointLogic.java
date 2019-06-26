package org.fresh.point.domain.service;

import org.fresh.point.domain.model.Point;
import org.fresh.point.domain.repository.PointRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("pointlogic")
public class PointLogic implements PointService {
	
	@Autowired
	private PointRepository pointRepository;
	
	@Override
	@Transactional
	public Point register(Point point) {
		return pointRepository.save(point);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Point findByCustomerId(Long customerId){
		return pointRepository.findOne(customerId);
	}
	
	@Override
	@Transactional
	public Point update(Long id, Long amount) {
		Point point = pointRepository.findOne(id);
		
		System.out.println("========point" + point );
		
		if(point != null) {
		Long amountTmp= point.getAmount()+ amount;
		System.out.println("========amount" + amount );
		System.out.println("========amountTmp" + amountTmp );
		point.setAmount(amountTmp);
		return pointRepository.save(point);
		} else {
			return null; 
			}
//		
//			BeanUtils.copyProperties(newPoint,  oldPoint, "id");
//			return pointRepository.save(oldPoint);
//		} 
	}
	
}