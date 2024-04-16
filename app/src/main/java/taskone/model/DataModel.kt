package taskone.model

data class DataModel(
    var marketStatus:String? = "Post-Close",
    var date:String? = "30/06/2021",
    var time:String? = "04:11 PM",
    var lossOverall: LossOverall? = LossOverall(),
    var gainOverall: GainOverall? = GainOverall(),
    var lossToday: LossToday? = LossToday(),
    var gainToday: GainToday? = GainToday(),
    var networth:String?= "192.178272",
    var profitLoss:String?= "-801.2",
)

data class LossOverall(
    var crPrice:String? = "48.2",
    var crValue:String? = "-15.5",
    var pl:String? = "24,100"
)
data class GainOverall(
    var crPrice:String? = "72.2",
    var crValue:String? = "-12.2",
    var pl:String? = "25,100"
)
data class GainToday(
    var crPrice:String? = "12",
    var crValue:String? = "-0.0",
    var pl:String? = "123"
)
data class LossToday(
    var crPrice:String? = "12",
    var crValue:String? = "-0.0",
    var pl:String? = "12"
)
