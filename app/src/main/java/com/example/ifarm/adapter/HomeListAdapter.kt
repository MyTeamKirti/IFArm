package com.example.ifarm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.PostData
import com.example.ifarm.model.ProductData1
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder
import kotlin.collections.ArrayList
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.ifarm.databinding.*

class HomeListAdapter(private var postList:ArrayList<PostData>,
                        internal var onItemClick: OnItemClickListner,
                        internal var currentFrag: Int
                      ): BaseBindingAdapter(postList){


    private var trendingProductList: ArrayList<ProductData1>? = null
    private var itemPos=0


    inner class ProductViewHolder1(var mBinding: CustomTrendingRecycleviewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            itemPos=position
            mBinding.tvTrendingShopsTitle.text=postList[position].categoryName
            setTrendingAdapter(mBinding)
            if (currentFrag==0){
                mBinding.tvTrendingShopsTitle.visibility= View.GONE
            }else{
                mBinding.tvTrendingShopsTitle.visibility= View.VISIBLE
            }
        }
    }

    inner class ProductViewHolder2(var mBinding: CustomCategoryRecycleviewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            itemPos=position
            mBinding.tvCategoryTitle.text=postList[position].categoryName
            setCategoryAdapter(mBinding)
            if (currentFrag==0){
                mBinding.tvCategoryTitle.visibility= View.GONE
            }else{
                mBinding.tvCategoryTitle.visibility= View.VISIBLE
            }
        }
    }

    inner class ProductViewHolder3(var mBinding: CustomExchangRecycleviewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            itemPos=position
            mBinding.tvExchangeTitle.text=postList[position].categoryName
            setExchangAdapter(mBinding)
        }
    }

    inner class ProductViewHolder4(var mBinding: CustomRatedRecycleviewLayoutBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            itemPos=position
            mBinding.tvRatedTitle.text=postList[position].categoryName
            setTopRatedProductsAdapter(mBinding)
        }
    }

    inner class ProductViewHolder5(var mBinding: CustomRatedRecycleviewLayoutBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            itemPos=position
            mBinding.tvRatedTitle.text=postList[position].categoryName
            setRatedProducts(mBinding)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        when (viewType) {
            1 -> {
                val binding = CustomTrendingRecycleviewBinding.inflate(
                    LayoutInflater.from(context), parent, false)
                return ProductViewHolder1(binding)
            }
            2 -> {
                val binding = CustomCategoryRecycleviewBinding.inflate(
                    LayoutInflater.from(context), parent, false)
                return ProductViewHolder2(binding)
            }
            3 -> {
                val binding = CustomExchangRecycleviewBinding.inflate(
                    LayoutInflater.from(context), parent, false)
                return ProductViewHolder3(binding)
            }
            4 -> {
                val binding = CustomRatedRecycleviewLayoutBinding.inflate(
                    LayoutInflater.from(context), parent, false)
                return ProductViewHolder4(binding)
            }
            5 -> {
                val binding = CustomRatedRecycleviewLayoutBinding.inflate(
                    LayoutInflater.from(context), parent, false)
                return ProductViewHolder5(binding)
            }
            else -> {
                val binding = CustomTrendingRecycleviewBinding.inflate(
                    LayoutInflater.from(context), parent, false)
                return ProductViewHolder1(binding)
            }
        }
    }

    override fun getItemViewType(position: Int):Int {
        return when (postList[position].card_type) {
            1 -> 1
            2 -> 2
            3 -> 3
            4 -> 4
            5 -> 5
            else -> -1
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    private fun setTrendingAdapter(mBinding: CustomTrendingRecycleviewBinding){
        trendingProductList= ArrayList()
        trendingProductList?.addAll(postList[itemPos].productList1)

        val mLayoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false)
        mBinding.rvTrendingProducts.layoutManager = mLayoutManager
//        val snapHelper = PagerSnapHelper()
//        snapHelper.attachToRecyclerView(mBinding.rvTrendingProducts)
        val trendingProductAdapter = ProductRawAdapter2(trendingProductList!!,currentFrag)
        mBinding.rvTrendingProducts.adapter = trendingProductAdapter
    }

    private fun setCategoryAdapter(mBinding: CustomCategoryRecycleviewBinding){
        trendingProductList= ArrayList()
        trendingProductList?.addAll(postList[itemPos].productList1)

        val mLayoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false)
        mBinding.rvCategoryProducts.layoutManager = mLayoutManager
        val categoryProductAdapter = ProductRawAdapter1(trendingProductList!!)
        mBinding.rvCategoryProducts.adapter = categoryProductAdapter
    }

    private fun setExchangAdapter(mBinding: CustomExchangRecycleviewBinding){
        trendingProductList= ArrayList()
        trendingProductList?.addAll(postList[itemPos].productList1)
        mBinding.tvExchangeTitle.visibility=View.VISIBLE

        val mLayoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false)
        mBinding.rvExchangeProducts.layoutManager = mLayoutManager
        val exchangeProductAdapter = ProductRawAdapter3(trendingProductList!!)
        mBinding.rvExchangeProducts.adapter = exchangeProductAdapter
    }

    private fun setTopRatedProductsAdapter(mBinding: CustomRatedRecycleviewLayoutBinding){
        trendingProductList= ArrayList()
        trendingProductList?.addAll(postList[itemPos].productList1)

        val mLayoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false)
        mBinding.rvRatedProducts.layoutManager = mLayoutManager
        val exchangeProductAdapter = ProductRawAdapter4(trendingProductList!!)
        mBinding.rvRatedProducts.adapter = exchangeProductAdapter
    }

    private fun setRatedProducts(mBinding: CustomRatedRecycleviewLayoutBinding)
    {
        trendingProductList= ArrayList()
        trendingProductList?.addAll(postList[itemPos].productList1)
        val mLayoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false)
        mBinding.rvRatedProducts.layoutManager = mLayoutManager
        val exchangeProductAdapter = ProductRawAdapter5(trendingProductList!!)
        mBinding.rvRatedProducts.adapter = exchangeProductAdapter
    }
}