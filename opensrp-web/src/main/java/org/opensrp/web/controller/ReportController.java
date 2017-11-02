package org.opensrp.web.controller;

import org.json.JSONException;
import org.opensrp.connector.openmrs.service.OpenmrsReportingService;
import org.opensrp.register.mcare.mapper.ELCORegisterMapper;
import org.opensrp.register.mcare.mapper.HHRegisterMapper;
import org.opensrp.register.mcare.report.mis1.MIS1Report;
import org.opensrp.register.mcare.report.mis1.MIS1ReportGenerator;
import org.opensrp.register.mcare.repository.AllMembers;
import org.opensrp.register.mcare.service.reporting.HHReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.opensrp.register.mcare.report.mis1.Filter;
import com.google.gson.Gson;

@Controller
public class ReportController {

	private OpenmrsReportingService reportService;
	private HHReportService hhReportService;
	private ELCORegisterMapper ecRegisterMapper;
	private HHRegisterMapper hhRegisterMapper;
	private AllMembers allMembers;
	
	
	@Autowired
	public ReportController(
			OpenmrsReportingService reportService,
			HHReportService hhReportService,
			ELCORegisterMapper ecRegisterMapper,
			HHRegisterMapper hhRegisterMapper, AllMembers allMembers) {
		this.reportService = reportService;
		this.hhReportService = hhReportService;
		this.ecRegisterMapper = ecRegisterMapper;
		this.hhRegisterMapper = hhRegisterMapper;
		this.allMembers = allMembers;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/report/report-definitions")
    public ResponseEntity<String> reportDefinitions() throws JSONException {
		return new ResponseEntity<>(new Gson().toJson(reportService.getReportDefinitions()),HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/report/report-data")
    public ResponseEntity<String> reportDefinitions(@RequestParam("uuid") String uuid) throws JSONException {
		return new ResponseEntity<>(new Gson().toJson(reportService.getReportData(uuid)),HttpStatus.OK);
    }

	@RequestMapping(headers = { "Accept=application/json" }, method = RequestMethod.POST, value = "/report/mis1")
    //@RequestMapping(method = RequestMethod.GET, value = "/report/mis1", headers = { "Accept=application/json" })
	public ResponseEntity<MIS1Report> getMis1Report(@RequestBody Filter filter) {
		MIS1ReportGenerator mis1ReportGenerator = new MIS1ReportGenerator();
		MIS1Report mis1Report = mis1ReportGenerator.getReportBasedOn(filter);
		return new ResponseEntity<>(mis1Report, HttpStatus.OK);
    }
	/*
	@RequestMapping(method = RequestMethod.GET, value = "/report/report-hh-7-days")
    public ResponseEntity<HHRegisterDTO> reportHHForPrev7Days(@RequestParam("provider-id") String providerId) {
		 HHRegister hhRegister = hhReportService.getHHDataVisitedPrev7Days(providerId);
	     return new ResponseEntity<>(hhRegisterMapper.mapToDTO(hhRegister), HttpStatus.OK);
    }*/
/*
    @RequestMapping(method = RequestMethod.GET, value = "/report/actions")
    @ResponseBody
    public List<Action> getNewActionForANM(@RequestParam("anmIdentifier") String anmIdentifier, @RequestParam("timeStamp") Long timeStamp){
        List<org.opensrp.scheduler.Action> actions = actionService.getNewAlertsForANM(anmIdentifier, timeStamp);
        return with(actions).convert(new Converter<org.opensrp.scheduler.Action, Action>() {
            @Override
            public Action convert(org.opensrp.scheduler.Action action) {
                return ActionConvertor.from(action);
            }
        });
    }*/

}
