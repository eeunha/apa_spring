
package com.project.apa.api.pharmacy.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class DispenseRepositoryImp implements DispenseRepository {

	@Override
	public List<Map<String, Object>> search(String word) {
		try {

			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("localhost", 9200, "http")));

			// 인덱스 선택
			SearchRequest searchRequest = new SearchRequest("dispense");

			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(100);

			// *** 검색 쿼리
			// - 검색에서 가장 흔한 패턴 > 프로젝트 사용
			// - bool query (must(match 검색어) + should(match_phrase 검색어)) > username + hospitalname
			searchSourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("username", word))
					.should(QueryBuilders.matchPhraseQuery("username", word)));

			searchRequest.source(searchSourceBuilder);

			// 실제 검색 요청
			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

			
			SearchHits searchHits = searchResponse.getHits();

			System.out.println("hits: " + searchHits.getHits().length);
			
			for (SearchHit hit : searchHits) {

				Map<String, Object> map = hit.getSourceAsMap();
				map.put("id", hit.getId());
				map.put("score", hit.getScore());
				list.add(map);

			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
