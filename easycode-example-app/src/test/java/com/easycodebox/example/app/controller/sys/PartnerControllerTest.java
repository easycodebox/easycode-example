package com.easycodebox.example.app.controller.sys;

import com.easycodebox.common.error.CodeMsg.Code;
import com.easycodebox.example.app.AbstractMvcTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PartnerControllerTest extends AbstractMvcTest {
	
	@Test
	public void testLoad() throws Exception {
		MockHttpServletRequestBuilder builder = get("/partner/load")
				.param("id", "a15b6");
		this.mockMvc.perform(builder)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.data").exists());
	}
	
	@Test
	public void testRemove() throws Exception {
		MockHttpServletRequestBuilder builder = get("/partner/remove")
				.param("ids", "a15b6");
		this.mockMvc.perform(builder)
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.code").value(Code.SUC_CODE));
	}
	
}
