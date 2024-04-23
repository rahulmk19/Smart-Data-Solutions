package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List<Member> importMembers(File inputFile) throws Exception {

		List<Member> members = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line = br.readLine();

			while (line != null) {
				line = br.readLine();
				if (line != null) {
					members.add(parseMember(line));
				}
			}
		}

		return members;

	}

	private Member parseMember(String line) {
		Member member = new Member();
		String id = line.substring(0, 12).trim();
		member.setId(id);
		
		String lastName = line.substring(12, 37).trim();
		member.setLastName(lastName);
		
		String firstName = line.substring(37, 62).trim();
		member.setFirstName(firstName);
		
		String address = line.substring(62, 92).trim();
		member.setAddress(address);
		
		String city = line.substring(92, 112).trim();
		member.setCity(city);
		
		String state = line.substring(112, 116).trim();
		member.setState(state);
		
		String zip = line.substring(116).trim();
		member.setZip(zip);
		return member;
	}

}
