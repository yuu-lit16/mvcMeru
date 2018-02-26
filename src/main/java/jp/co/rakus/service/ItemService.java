package jp.co.rakus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.domain.Item;
import jp.co.rakus.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> findLimit30() {
		return itemRepository.findLimit30();
	}

	public int getNumOfTotalData() {
		return itemRepository.getNumOfTotalData();
	}

	public List<Item> findByLimitAndOffset(int limit, int offset) {
		return itemRepository.findByLimitAndOffset(limit, offset);
	}

}
