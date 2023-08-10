package com.example.rickandmorty.presentation.list.favs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentFavsListComposeBinding
import com.example.rickandmorty.domain.model.CharacterModel
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavsListFragmentCompose : Fragment() {

    private lateinit var binding: FragmentFavsListComposeBinding
    private val viewModel : FavsListComposeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFavsListComposeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        startObserver()

        binding.cvFavoriteList.setContent {
            PrintList()
        }
    }

    private fun startObserver() {
        viewModel.data.observe(viewLifecycleOwner) {
            it
        }
        viewModel.getList()
    }

    @Composable
    private fun PrintList(){
        MakeList()
    }

    @Composable
    fun MakeList() {
        val viewModel : FavsListComposeViewModel = koinViewModel()
        val list = viewModel.data.observeAsState()
        //viewModel.data.observe(viewLifecycleOwner) {
        //}
       // viewModel.getList()
        //val list = viewModel.data

        LazyColumn(
            modifier = Modifier.padding(
                vertical = 20.dp   // --> VARIABLE GLOBAL!!
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(list.value?.size ?: 0) { it ->
                val item = list.value?.get(it)
               item?.let {
                   Log.i("MODEL", it.name)
                   GetCell(it)
               }
            }
        }
    }

    @Composable
    private fun GetCell(character : CharacterModel) = Card(
        modifier = Modifier.padding(20.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ){
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .clickable { },
            verticalAlignment = Alignment.CenterVertically
        ) {
            // TO FUNTION
            AsyncImage(
                modifier = Modifier
                    .size(170.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.rick_and_morty_background),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(character.photo).build(), contentDescription = ""
            )
            // TO FUNTION
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            )  {
                Column(
                    modifier = Modifier.weight(1F),
                    horizontalAlignment = Alignment.CenterHorizontally
                )  {
                    Text(
                        text = character.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}