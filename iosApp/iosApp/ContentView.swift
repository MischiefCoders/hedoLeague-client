import SwiftUI
import shared

struct ContentView: View {
    @StateObject var tablesViewModel: TablesViewModel = TablesViewModel()

	var body: some View {
        TablesLayout(viewModel: tablesViewModel)
	}
}

struct TablesLayout: View {
    @StateObject var viewModel: TablesViewModel
    
    var body: some View {
        ScrollView {
            LazyVStack(alignment: .leading) {
                ForEach(viewModel.tables, id: \.self) { uiModel in
                    RankInfoItem(uiModel: uiModel)
                }
            }
        }.onAppear {
            viewModel.getTables()
        }
    }
}

struct RankInfoItem: View {
    var uiModel: RankInfoUiModel
    var body: some View {
        Text(uiModel.team)
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        Group {
            ContentView()
            ContentView()
            ContentView()
        }
	}
}
