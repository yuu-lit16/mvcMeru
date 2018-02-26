package jp.co.rakus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.domain.Item;


@Repository
@Transactional
public class ItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** Item型のRowMapper */
	private static final RowMapper<Item> RowMapper = (rs, i) -> {
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setCondition(rs.getInt("condition"));
		// item.setCategory(rs.getInt("category"));
		item.setCategory(rs.getString("category"));
		item.setBrand(rs.getString("brand"));
		item.setPrice(rs.getDouble("price"));
		item.setDescription(rs.getString("description"));

		return item;
	};

	/**
	 * Itemテーブルの先頭からデータを30件取得
	 * @return List<Item>
	 * */
	public List<Item> findLimit30() {

		String sql = "select items.id,items.name,items.condition,category.name_all as \"category\",items.brand,items.price,items.shipping,items.description"
				+ " from items left outer join category on items.category = category.id order by items.id limit  30";

		List<Item> itemList = jdbc.query(sql, RowMapper);

		return itemList;
	}

	/**
	 * Itemテーブルのデータ総数を返す
	 *
	 * @return int count(*)で取得した総数
	 *
	 */
	public int getNumOfTotalData() {
		int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM items", Integer.class);
		return count;
	}

	/**
	 * ページネーション時にselectするメソッド
	 *
	 * @param Limit
	 *            , Offset
	 *
	 * @return Item
	 *
	 */
	public List<Item> findByLimitAndOffset(int limit, int offset) {

		String sql = "select items.id,items.name,items.condition,category.name_all as \"category\",items.brand,items.price,items.shipping,items.description"
				+ " from items left outer join category on items.category = category.id order by items.id limit :limit offset :offset";

		SqlParameterSource param = new MapSqlParameterSource().addValue("limit", limit).addValue("offset", offset);

		List<Item> itemList = jdbc.query(sql, param, RowMapper);

		return itemList;

	}

}
