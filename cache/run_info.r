### Indicate this as a MET database query ###
Met_query<- "F"
### Use MySQL database for queries
AMET_DB<- "T"
#### Main Database Query String ###
query<-" and s.stat_id=d.stat_id and (d.stat_id='10510003' or d.stat_id='11130003' or d.stat_id='11179001' or d.stat_id='20200045' or d.stat_id='20904008' or d.stat_id='20904009' or d.stat_id='20905004' or d.stat_id='20905005' or d.stat_id='20905006' or d.stat_id='20905007' or d.stat_id='20905008' or d.stat_id='20905009' or d.stat_id='20905011' or d.stat_id='20905012' or d.stat_id='21229000' or d.stat_id='40059000' or d.stat_id='40071003' or d.stat_id='40134020' or d.stat_id='40213015' or d.stat_id='40239000' or d.stat_id='40258034' or d.stat_id='60010013' or d.stat_id='60190500' or d.stat_id='60192016' or d.stat_id='60670015' or d.stat_id='60731017' or d.stat_id='60731019' or d.stat_id='60731022' or d.stat_id='60731024' or d.stat_id='60798002' or d.stat_id='60799001' or d.stat_id='60812004' or d.stat_id='61030007' or d.stat_id='80010008' or d.stat_id='80130014' or d.stat_id='80310028' or d.stat_id='80450020' or d.stat_id='80450022' or d.stat_id='80450023' or d.stat_id='80490003' or d.stat_id='80690006' or d.stat_id='80690013' or d.stat_id='80690014' or d.stat_id='80810003' or d.stat_id='80850005' or d.stat_id='80930002' or d.stat_id='80970008' or d.stat_id='120013012' or d.stat_id='120110035' or d.stat_id='120570112' or d.stat_id='120570113' or d.stat_id='120860035' or d.stat_id='120950009' or d.stat_id='121030027' or d.stat_id='131150006' or d.stat_id='150034001' or d.stat_id='150034100' or d.stat_id='150090025' or d.stat_id='160499991' or d.stat_id='160530003' or d.stat_id='171339001' or d.stat_id='180890035' or d.stat_id='181270028' or d.stat_id='181730004' or d.stat_id='181730005' or d.stat_id='181730012' or d.stat_id='191531579' or d.stat_id='191930021' or d.stat_id='201810003' or d.stat_id='211011011' or d.stat_id='220190011' or d.stat_id='220330015' or d.stat_id='220890006' or d.stat_id='220930003' or d.stat_id='220958001' or d.stat_id='220958002' or d.stat_id='220958003' or d.stat_id='220958004' or d.stat_id='220958005' or d.stat_id='220958006' or d.stat_id='220958007' or d.stat_id='220990001' or d.stat_id='221210002' or d.stat_id='230072002' or d.stat_id='230072003' or d.stat_id='230173002' or d.stat_id='240018881' or d.stat_id='240018882' or d.stat_id='240050009' or d.stat_id='240053474' or d.stat_id='260370002' or d.stat_id='261150963' or d.stat_id='261150964' or d.stat_id='261470913' or d.stat_id='261470914' or d.stat_id='261630097' or d.stat_id='261631010' or d.stat_id='261631011' or d.stat_id='270177417' or d.stat_id='270530910' or d.stat_id='270531909' or d.stat_id='271230818' or d.stat_id='271231907' or d.stat_id='271231908' or d.stat_id='280490021' or d.stat_id='290719001' or d.stat_id='290719002' or d.stat_id='290939009' or d.stat_id='290939010' or d.stat_id='290939011' or d.stat_id='290999007' or d.stat_id='290999008' or d.stat_id='290999009' or d.stat_id='291130004' or d.stat_id='291839002' or d.stat_id='291839004' or d.stat_id='310550057' or d.stat_id='311090025' or d.stat_id='320031501' or d.stat_id='320031502' or d.stat_id='320311007' or d.stat_id='330012005' or d.stat_id='330093002' or d.stat_id='340170008' or d.stat_id='350450020' or d.stat_id='360010013' or d.stat_id='360637001' or d.stat_id='360810125' or d.stat_id='360890004' or d.stat_id='360890005' or d.stat_id='360990002' or d.stat_id='361090002' or d.stat_id='370190005' or d.stat_id='370210036' or d.stat_id='370210037' or d.stat_id='370510010' or d.stat_id='370870013' or d.stat_id='371190046' or d.stat_id='371450004' or d.stat_id='381010003' or d.stat_id='381050106' or d.stat_id='390130006' or d.stat_id='390170022' or d.stat_id='390170023' or d.stat_id='390290023' or d.stat_id='390350074' or d.stat_id='390350075' or d.stat_id='390530004' or d.stat_id='390530005' or d.stat_id='390530006' or d.stat_id='390950035' or d.stat_id='391530025' or d.stat_id='391550013' or d.stat_id='391550014' or d.stat_id='400232017' or d.stat_id='400370146' or d.stat_id='400390856' or d.stat_id='400470555' or d.stat_id='400510065' or d.stat_id='400690324' or d.stat_id='400819025' or d.stat_id='400970188' or d.stat_id='401010170' or d.stat_id='401090097' or d.stat_id='401130226' or d.stat_id='401159027' or d.stat_id='401470217' or d.stat_id='410290203' or d.stat_id='410430104' or d.stat_id='410470123' or d.stat_id='410512008' or d.stat_id='410512009' or d.stat_id='410512010' or d.stat_id='410610123' or d.stat_id='421330012' or d.stat_id='440070031' or d.stat_id='440070032' or d.stat_id='440070033' or d.stat_id='450210004' or d.stat_id='450510008' or d.stat_id='450910008' or d.stat_id='450918801' or d.stat_id='471636001' or d.stat_id='471636002' or d.stat_id='480291080' or d.stat_id='480371031' or d.stat_id='482011052' or d.stat_id='482031079' or d.stat_id='482151046' or d.stat_id='482271072' or d.stat_id='482331073' or d.stat_id='482451071' or d.stat_id='483031028' or d.stat_id='483311075' or d.stat_id='483491081' or d.stat_id='483611083' or d.stat_id='483751077' or d.stat_id='483951076' or d.stat_id='484391053' or d.stat_id='484491078' or d.stat_id='490450004' or d.stat_id='510590031' or d.stat_id='530030333' or d.stat_id='530050003' or d.stat_id='530070012' or d.stat_id='530090017' or d.stat_id='530170018' or d.stat_id='530251003' or d.stat_id='530330031' or d.stat_id='530330034' or d.stat_id='530330035' or d.stat_id='530330052' or d.stat_id='530330053' or d.stat_id='530330054' or d.stat_id='530330055' or d.stat_id='530330056' or d.stat_id='530530024' or d.stat_id='530650005' or d.stat_id='530730013' or d.stat_id='530730017' or d.stat_id='540390020' or d.stat_id='540530001' or d.stat_id='540578883' or d.stat_id='550051006' or d.stat_id='550531002' or d.stat_id='550531003' or d.stat_id='550870015' or d.stat_id='551010020' or d.stat_id='551211003' or d.stat_id='551211004' or d.stat_id='560010008' or d.stat_id='560010009' or d.stat_id='560010010' or d.stat_id='560050013' or d.stat_id='560050014' or d.stat_id='560050015' or d.stat_id='560070008' or d.stat_id='560070009' or d.stat_id='560070010' or d.stat_id='560090010' or d.stat_id='560090011' or d.stat_id='560130003' or d.stat_id='560150005' or d.stat_id='560210002' or d.stat_id='560250005' or d.stat_id='560370018' or d.stat_id='560370021' or d.stat_id='560450004' or d.stat_id='720250007' or d.stat_id='720570011' or d.stat_id='10510004' or d.stat_id='20500001' or d.stat_id='20904101' or d.stat_id='20904102' or d.stat_id='20904103' or d.stat_id='21859000' or d.stat_id='40213016' or d.stat_id='50310005' or d.stat_id='60010015' or d.stat_id='60051033' or d.stat_id='60150007' or d.stat_id='60290018' or d.stat_id='60333002' or d.stat_id='60550004' or d.stat_id='60650010' or d.stat_id='60719011' or d.stat_id='80077004' or d.stat_id='80290007' or d.stat_id='90079007' or d.stat_id='171150117' or d.stat_id='171150217' or d.stat_id='171150317' or d.stat_id='172010118' or d.stat_id='180890036' or d.stat_id='180890037' or d.stat_id='181530007' or d.stat_id='211110080' or d.stat_id='230190017' or d.stat_id='250030008' or d.stat_id='250036001' or d.stat_id='250130018' or d.stat_id='250170010' or d.stat_id='260650018' or d.stat_id='261630098' or d.stat_id='261630099' or d.stat_id='261630100' or d.stat_id='270213410' or d.stat_id='280110002' or d.stat_id='291439001' or d.stat_id='291439002' or d.stat_id='291439003' or d.stat_id='300830002' or d.stat_id='301110087' or d.stat_id='330012006' or d.stat_id='360010014' or d.stat_id='360010015' or d.stat_id='361030044' or d.stat_id='380250004' or d.stat_id='390350076' or d.stat_id='390670004' or d.stat_id='390830003' or d.stat_id='390850008' or d.stat_id='390890008' or d.stat_id='391510024' or d.stat_id='400790467' or d.stat_id='401050207' or d.stat_id='401210417' or d.stat_id='410050301' or d.stat_id='410197000' or d.stat_id='410271001' or d.stat_id='410352222' or d.stat_id='410510065' or d.stat_id='410510100' or d.stat_id='410510101' or d.stat_id='410510102' or d.stat_id='410510103' or d.stat_id='410510104' or d.stat_id='410510200' or d.stat_id='410510201' or d.stat_id='410510202' or d.stat_id='410510300' or d.stat_id='410510304' or d.stat_id='410510400' or d.stat_id='410510401' or d.stat_id='410512011' or d.stat_id='410650008' or d.stat_id='410650500' or d.stat_id='410650501' or d.stat_id='410650502' or d.stat_id='410650503' or d.stat_id='450070006' or d.stat_id='450151002' or d.stat_id='471636004' or d.stat_id='481611084' or d.stat_id='484011082' or d.stat_id='490170006' or d.stat_id='490210005' or d.stat_id='490352005' or d.stat_id='510230004' or d.stat_id='510710007' or d.stat_id='511210009' or d.stat_id='515800008' or d.stat_id='530230001' or d.stat_id='530330067' or d.stat_id='530330069' or d.stat_id='530390006' or d.stat_id='530470004' or d.stat_id='530730019' or d.stat_id='550191001' or d.stat_id='550531004' or d.stat_id='560190004' or d.stat_id='560210003' or d.stat_id='560290003' or d.stat_id='560330006' or d.stat_id='560370022' or d.stat_id='560390009' or d.stat_id='800020024' or d.stat_id='20900040' or d.stat_id='50070002' or d.stat_id='50070003' or d.stat_id='60270023' or d.stat_id='60292019' or d.stat_id='60612003' or d.stat_id='60650500' or d.stat_id='80470003' or d.stat_id='110010053' or d.stat_id='120990022' or d.stat_id='170310119' or d.stat_id='170310219' or d.stat_id='180190010' or d.stat_id='180570008' or d.stat_id='180810003' or d.stat_id='350150010' or d.stat_id='350439028' or d.stat_id='371310003' or d.stat_id='390670005' or d.stat_id='410352040' or d.stat_id='410670006' or d.stat_id='420070035' or d.stat_id='420510524' or d.stat_id='421150215' or d.stat_id='470990003' or d.stat_id='471130010' or d.stat_id='471252001' or d.stat_id='471636003' or d.stat_id='490030004' or d.stat_id='490351007' or d.stat_id='490353015' or d.stat_id='490354002' or d.stat_id='490479000' or d.stat_id='530330089' or d.stat_id='530550001' or d.stat_id='540110007' or d.stat_id='551270006' or d.stat_id='560050016' or d.stat_id='560370024' or d.stat_id='720970007' or d.stat_id='none') and d.ob_dates BETWEEN 20160101 and 20161231 and d.ob_datee BETWEEN 20160101 and 20161231 and (d.ob_hour >= 00 and d.ob_hour <= 23)"
### Process ID number ###
pid<-"673475"
### Database Name ###
dbase<-"amad_CMAQ_v53_Dev"
### Parameter Occurrence (PO) Code ###
POCode<-""
### Directory to write figures ###
figdir<-"C:\\Users\\Administrator\\OneDrive\\Profile\\Documents\\NetBeansProjects\\JavaGUIApp\\cache"
### Use only common sites among mulitple simulations ###
common_sites<-"y"
### Species ###
species_in<-"O3_8hrmax"
custom_species<-""
custom_species_name<-""
custom_units<-""
### Project ID Name 1 ###
run_name1<-"CMAQv531_2016fh_12US1_M3Dry_WRFv381_NoBidi_fixedBCs"
### Additional Run Names (used for model-to-model comparisons) ###
run_name2<-""
run_name3<-""
run_name4<-""
run_name5<-""
run_name6<-""
run_name7<-""
### Array of Observation Network Flags ###
#inc_networks<-
inc_csn<-""
inc_improve<-""
inc_castnet<-""
inc_castnet_hr<-""
inc_castnet_daily<-""
inc_castnet_drydep<-""
inc_capmon<-""
inc_naps<-""
inc_naps_daily_o3<-""
inc_nadp<-""
inc_airmon_dep<-""
inc_amon<-""
inc_aqs_hourly<-""
inc_aqs_daily_O3<-"y"
inc_aqs_daily<-""
inc_aqs_daily_pm<-""
inc_search<-""
inc_search_daily<-""
inc_aeronet<-""
inc_fluxnet<-""
inc_noaa_esrl_o3<-""
inc_toar<-""
inc_mdn<-""
inc_tox<-""
inc_mod<-""
## European Networks ##
inc_admn<-""
inc_aganet<-""
inc_airbase_hourly<-""
inc_airbase_daily<-""
inc_aurn_hourly<-""
inc_aurn_daily<-""
inc_emep_hourly<-""
inc_emep_daily<-""
inc_emep_daily_o3<-""
inc_namn<-""
## Campaigns ##
inc_calnex<-""
inc_soas<-""
inc_special<-""
### Universal Plot Options ###
dates<-"20160101 to 20161231"
custom_title<-""
png_from_html<-""
png_res<-300
x_label_angle<-0
### Plotly Options ###
img_height<-"900"
img_width<-"1600"
### Flag for Time Averaging ###
averaging<-"n"
remove_negatives<-"y"
use_avg_stats<-""
aggregate_data<-""
merge_statid_POC<-"y"
### Time Series Plot Options ###
inc_legend<-"y"
inc_points<-"y"
inc_bias<-"y"
inc_rmse<-""
inc_corr<-""
use_var_mean<-""
obs_per_day_limit<-0
avg_func<-mean
avg_func_name<-"mean"
line_width<-"1"
### Kelly Plot Options ###
nmb_max<-NULL
nme_max<-NULL
mb_max<-NULL
me_min<-NULL
me_max<-NULL
rmse_min<-NULL
rmse_max<-NULL
nmb_int<-NULL
nme_int<-NULL
### Unique color ranges for some plots ###
color_ranges<-"n"
### Monitoring Sites to Include ###
site<-"All"
### States to Include ###
state<-"All"
### Regional Planning Organizations to Include ###
rpo<-"None"
### Priciple Component Analysis (PCA) Region ###
pca<-"None"
### Climate Region ###
clim_reg<-""
### Binned Plot Options ###
pca_flag<-""
bin_by_mod<-""
inc_error<-""
### Landuse Category
loc_setting<-""
### Flag to Include or Remove Zero Precipitation Observations ###
zeroprecip<-""
### Numerical Limit for Data Completeness as minimum number of required observations (used when calulating site statistics or averages)###
coverage_limit<-75
all_valid<-"y"
all_valid_amon<-""
### Numerical Limit for Data Completeness as minimum number of required observations (used when calulating site statistics or averages)###
num_obs_limit<-1
### Flag for Soccer and Bugle Plots Setting NMB/NME or FB/FE ###
soccerplot_opt<-1
### Flag for PAVE Overlay; 1=hourly, 2=daily ###
overlay_opt<-1
### Flags for Confidence Lines to Plot on Scatterplots ###
conf_line<-""
trend_line<-"y"
### Scatterplot x and y axes limits ###
x_axis_min<-NULL
x_axis_max<-NULL
y_axis_min<-NULL
y_axis_max<-NULL
bias_y_axis_min<-NULL
bias_y_axis_max<-NULL
density_zlim<-NULL
num_dens_bins<-NULL
max_limit<-70
### Hourly Boxplot Options ###
inc_whiskers<-""
inc_ranges<-"y"
inc_median_lines<-""
remove_mean<-""
overlap_boxes<-""
### File containing list of stations created dynamically by the user ###
stat_file<-""
### Spatial Plot Options ###
symbsizfac<-1
plot_radius<-0
outlier_radius<-20
fill_opacity<-0.8
num_ints<-NULL
perc_error_max<-NULL
abs_error_max<-NULL
rmse_range_max<-NULL
perc_range_min<-NULL
perc_range_max<-NULL
abs_range_min<-NULL
abs_range_max<-NULL
diff_range_min<-NULL
diff_range_max<-NULL
greyscale <-""
inc_counties <-"y"
hist_max<-NULL
map_type<-1
quantile_min<-0.001
quantile_max<-0.999
### Stacked Bar Charts Options ###
inc_FRM_adj<-"y"
use_median<-""
### Array of flags for which statistics to include on scatter plots ###
stats_flags<-c("","","","y","","","","y","y","","","","","","","y","y","","")
### Flag to include run info text on plots ###
run_info_text<-"y"
### Set Scatter Plot Symbols and Colors ###
plot_colors<-c("grey60","red","blue","green4","yellow3","orange2","brown","purple")
plot_colors2<-c("grey60","red","blue","green4","yellow3","orange2","brown","purple")
plot_symbols<-c(16,17,15,18,11,8,4)
### Start and End Year/Month ###
year_start<-2016
year_end<-2016
month_start<-01
month_end<-12
day_start<-01
day_end<-31
start_date <- as.integer(paste(year_start,sprintf("%02d",month_start),sprintf("%02d",day_start),sep=""))
end_date   <- as.integer(paste(year_end,sprintf("%02d",month_end),sprintf("%02d",day_end),sep=""))
#############################
### Setup Networks Arrays ###
#############################
network_names <- NULL
network_label <- NULL
if (inc_improve == "y") {
   network_names <- c(network_names,"IMPROVE")
   network_label <- c(network_label,"IMPROVE")
}
if (inc_csn == "y") {
   network_names <- c(network_names,"CSN")
   network_label <- c(network_label,"CSN")
}
if (inc_castnet == "y") {
   network_names <- c(network_names,"CASTNET")
   network_label <- c(network_label,"CASTNET")
}
if (inc_castnet_hr == "y") {
   network_names <- c(network_names,"CASTNET_Hourly")
   network_label <- c(network_label,"CASTNET")
}
if (inc_castnet_daily == "y") {
   network_names <- c(network_names,"CASTNET_Daily")
   network_label <- c(network_label,"CASTNET")
}
if (inc_castnet_drydep == "y") {
   network_names <- c(network_names,"CASTNET_Drydep")
   network_label <- c(network_label,"CASTNET")
}
if (inc_capmon == "y") {
   network_names <- c(network_names,"CAPMON")
   network_label <- c(network_label,"CAPMON")
}
if (inc_naps == "y") {
   network_names <- c(network_names,"NAPS")
   network_label <- c(network_label,"NAPS")
}
if (inc_naps_daily_o3 == "y") {
   network_names <- c(network_names,"NAPS_Daily_O3")
   network_label <- c(network_label,"NAPS Daily")
}
if (inc_nadp == "y") {
   network_names <- c(network_names,"NADP")
   network_label <- c(network_label,"NADP")
}
if (inc_airmon_dep == "y") {
   network_names <- c(network_names,"AIRMON")
   network_label <- c(network_label,"AIRMON")
}
if (inc_amon == "y") {
   network_names <- c(network_names,"AMON")
   network_label <- c(network_label,"AMON")
}
if (inc_aqs_hourly == "y") {
   network_names <- c(network_names,"AQS_Hourly")
   network_label <- c(network_label,"AQS_Hourly")
}
if (inc_aqs_daily_O3 == "y") {
   network_names <- c(network_names,"AQS_Daily_O3")
   network_label <- c(network_label,"AQS_Daily")
}
if (inc_aqs_daily == "y") {
   network_names <- c(network_names,"AQS_Daily")
   network_label <- c(network_label,"AQS_Daily")
}
if (inc_aqs_daily_pm == "y") {
   network_names <- c(network_names,"AQS_Daily_PM")
   network_label <- c(network_label,"AQS_Daily")
}
if (inc_search == "y") {
   network_names <- c(network_names,"SEARCH")
   network_label <- c(network_label,"SEARCH")
}
if (inc_search_daily == "y") {
   network_names <- c(network_names,"SEARCH_Daily")
   network_label <- c(network_label,"SEARCH_Daily")
}
if (inc_aeronet == "y") {
   network_names <- c(network_names,"AERONET")
   network_label <- c(network_label,"AERONET")
}
if (inc_fluxnet == "y") {
   network_names <- c(network_names,"FLUXNET")
   network_label <- c(network_label,"FluxNet")
}
if (inc_noaa_esrl_o3 == "y") {
   network_names <- c(network_names,"NOAA_ESRL_O3")
   network_label <- c(network_label,"NOAA ESRL")
}
if (inc_toar == "y") {
   network_names <- c(network_names,"TOAR")
   network_label <- c(network_label,"TOAR")
}
if (inc_mdn == "y") {
   network_names <- c(network_names,"MDN")
   network_label <- c(network_label,"MDN")
}
if (inc_tox == "y") {
   network_names <- c(network_names,"Toxics")
   network_label <- c(network_label,"Toxics")
}
if (inc_mod == "y") {
   network_names <- c(network_names,"Model_Model")
   network_label <- c(network_label,"Mod v. Mod")
}
if (inc_admn == "y") {
   network_names <- c(network_names,"ADMN")
   network_label <- c(network_label,"ADMN")
}
if (inc_aganet == "y") {
   network_names <- c(network_names,"AGANET")
   network_label <- c(network_label,"AGANET")
}
if (inc_airbase_hourly == "y") {
   network_names <- c(network_names,"AirBase_Hourly")
   network_label <- c(network_label,"AirBase")
}
if (inc_airbase_daily == "y") {
   network_names <- c(network_names,"AirBase_Daily")
   network_label <- c(network_label,"AirBase")
}
if (inc_aurn_hourly == "y") {
   network_names <- c(network_names,"AURN_Hourly")
   network_label <- c(network_label,"AURN")
}
if (inc_aurn_daily == "y") {
   network_names <- c(network_names,"AURN_Daily")
   network_label <- c(network_label,"AURN")
}
if (inc_emep_hourly == "y") {
   network_names <- c(network_names,"EMEP_Hourly")
   network_label <- c(network_label,"EMEP")
}
if (inc_emep_daily == "y") {
   network_names <- c(network_names,"EMEP_Daily")
   network_label <- c(network_label,"EMEP")
}
if (inc_calnex == "y") {
   network_names <- c(network_names,"CALNEX")
   network_label <- c(network_label,"CALNEX")
}
if (inc_soas == "y") {
   network_names <- c(network_names,"SOAS")
   network_label <- c(network_label,"SOAS")
}
if (inc_special == "y") {
   network_names <- c(network_names,"Special")
   network_label <- c(network_label,"Special")
}


species <- unlist(strsplit(species_in,","))
species <- gsub("_ob","",species)
total_networks<-length(network_names)
network1 <-network_names[[1]]
ametptype <-""

